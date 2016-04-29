package com.lepu.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lepu.dao.impl.CommonDao;
import com.lepu.system.model.SystemMenu;
import com.lepu.system.model.SystemPermission;
import com.lepu.system.model.SystemRoleMenu;
import com.lepu.system.model.SystemRolePermission;
import com.lepu.system.service.SystemMenuService;
import com.lepu.system.service.SystemRoleService;
import com.lepu.system.service.SystemUserService;

@Service("menuDao")
public class SystemMenuServiceImpl implements SystemMenuService {

	@Autowired
	private CommonDao<SystemMenu> menuDao;

	@Autowired
	private CommonDao<SystemRoleMenu> roleMenuDao;

	@Autowired
	private SystemUserService userService;

	@Autowired
	private SystemRoleService roleService;

	@Override
	public List<SystemMenu> getAllMenuList() {
		List<SystemMenu> list = null;
		list = menuDao.findByHQL("FROM SystemMenu WHERE isDelete != 1");
		return list;
	}

	@Override
	public List<Map<String, Object>> getMenuTreeByRoleId(Integer roleId) {
		List<Map<String, Object>> list = new ArrayList();
		List<SystemMenu> menuList = getParentMenu();
		for (SystemMenu menu : menuList) {
			Map<String, Object> menuMap = new HashMap();
			menuMap.put("id", "menu" + menu.getId());
			menuMap.put("name", menu.getName() + "菜单");
			menuMap.put("pId", 0);
			menuMap.put("tag", "menu");
			SystemRoleMenu roleMenu = roleService.getRoleMenu(roleId, menu.getId());
			if (roleMenu != null) {
				menuMap.put("checked", true);
			}
			list.add(menuMap);
			List<SystemMenu> subMenuList = getSubMenu(menu.getId());
			for (SystemMenu subMenu : subMenuList) {
				Map<String, Object> subMenuMap = new HashMap();
				subMenuMap.put("id", "subMenu" + subMenu.getId());
				subMenuMap.put("name", subMenu.getName() + "菜单");
				subMenuMap.put("pId", "menu" + menu.getId());
				subMenuMap.put("tag", "menu");
				SystemRoleMenu roleSubMenu = roleService.getRoleMenu(roleId, subMenu.getId());
				if (roleSubMenu != null) {
					subMenuMap.put("checked", true);
				}
				list.add(subMenuMap);
				for (SystemPermission permission : subMenu.getSystemPermission()) {
					Map<String, Object> permMap = new HashMap();
					permMap.put("id", "perm" + permission.getId());
					permMap.put("name", permission.getName() + "[url:" + permission.getPermission() + "]");
					permMap.put("pId", "subMenu" + subMenu.getId());
					permMap.put("tag", "perm");
					SystemRolePermission rolePermission = roleService.getRolePermission(roleId, permission.getId());
					if (rolePermission != null) {
						permMap.put("checked", true);
					}
					list.add(permMap);
				}
			}

		}
		System.out.println(list);
		return list;
	}

	@Override
	public void addMenu(SystemMenu menu) {
		menuDao.save(menu);
	}

	@Override
	public List<SystemMenu> getParentMenu() {
		List<SystemMenu> list = null;
		list = menuDao.findByHQL("FROM SystemMenu WHERE parentId = 0 AND isDelete != 1");
		return list;
	}

	@Override
	public List<SystemMenu> getSubMenu(Integer menuId) {
		List<SystemMenu> list = null;
		list = menuDao.findByHQL("FROM SystemMenu WHERE parentId = ? AND isDelete != 1", new Object[] { menuId });
		return list;
	}

	@Override
	public List<SystemMenu> getParentMenuByUser(Integer userId) {
		List<SystemMenu> menuList = new ArrayList();
		Integer roleId = userService.getRoleIdByUser(userId);
		List<SystemRoleMenu> list = roleMenuDao.findByHQL("FROM SystemRoleMenu WHERE roleId = ? AND parentId = 0", new Object[] { roleId });
		for (SystemRoleMenu roleMenu : list) {
			SystemMenu menu = menuDao.findObjectByHQL("FROM SystemMenu WHERE id = ? AND isDelete != 1", new Object[] { roleMenu.getMenuId() });
			List<SystemMenu> subMenuList = getSubMenuByUser(userId, menu.getId());
			menu.setSubMenus(subMenuList);
			menuList.add(menu);
		}
		return menuList;
	}

	@Override
	public List<SystemMenu> getSubMenuByUser(Integer userId, Integer parentId) {
		List<SystemMenu> menuList = new ArrayList();
		Integer roleId = userService.getRoleIdByUser(userId);
		List<SystemRoleMenu> list = roleMenuDao.findByHQL("FROM SystemRoleMenu WHERE roleId = ? AND parentId = ?", new Object[] { roleId, parentId });
		for (SystemRoleMenu roleMenu : list) {
			SystemMenu menu = menuDao.findObjectByHQL("FROM SystemMenu WHERE id = ? AND isDelete != 1", new Object[] { roleMenu.getMenuId() });
			menuList.add(menu);
		}
		return menuList;
	}

	@Override
	public SystemMenu getMenuById(Integer menuId) {
		SystemMenu menu = menuDao.findObjectByHQL("FROM SystemMenu WHERE id = ? AND isDelete != 1", new Object[] { menuId });
		return menu;
	}

	@Override
	public void deleteMenu(Integer menuId) {
		SystemMenu menu = menuDao.get(SystemMenu.class, menuId);
		if (menu.getSystemPermission() != null && menu.getSystemPermission().size() > 0) {
			for (SystemPermission perm : menu.getSystemPermission()) {
			}
		}
		menu.setIsDelete(1);
		menuDao.isDelete(menu);
	}

	@Override
	public void updateMenu(SystemMenu menu) {
		SystemMenu updateMenu = getMenuById(menu.getId());
		System.out.println(menu.getId());
		System.out.println("updateMenu:" + updateMenu);
		System.out.println("执行保存");
		if (updateMenu != null) {
			updateMenu.setName(menu.getName());
			updateMenu.setUpdateTime(new Date());
			updateMenu.setDescription(menu.getDescription());
			updateMenu.setIcon(menu.getIcon());
			updateMenu.setParentId(menu.getParentId());
			updateMenu.setUrl(menu.getUrl());
			menuDao.update(updateMenu);
			System.out.println("保存成功");
		}
	}

}
