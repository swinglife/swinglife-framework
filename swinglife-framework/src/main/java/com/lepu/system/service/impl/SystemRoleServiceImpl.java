package com.lepu.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lepu.dao.impl.CommonDao;
import com.lepu.system.model.SystemMenu;
import com.lepu.system.model.SystemPermission;
import com.lepu.system.model.SystemRole;
import com.lepu.system.model.SystemRoleMenu;
import com.lepu.system.model.SystemRolePermission;
import com.lepu.system.service.SystemMenuService;
import com.lepu.system.service.SystemRoleService;

@Service("roleService")
public class SystemRoleServiceImpl implements SystemRoleService {

	@Autowired
	private CommonDao<SystemRole> roleDao;

	@Autowired
	private SystemMenuService menuService;

	@Autowired
	private CommonDao<SystemRoleMenu> roleMenuDao;

	@Autowired
	private CommonDao<SystemRolePermission> rolePermissionDao;

	@Autowired
	private CommonDao<SystemPermission> permissionDao;

	@Override
	public List<SystemRole> getAllRoleList() {
		List<SystemRole> list = null;
		list = roleDao.findByHQL("FROM SystemRole");
		return list;
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
	public boolean editRoleMenuAndPermission(Integer roleId, String[] menuIds, String[] permIds) throws Exception {
		// 首先清空原有的菜单
		List<SystemRoleMenu> list = roleMenuDao.findByHQL("FROM SystemRoleMenu WHERE roleId = ?", new Object[] { roleId });
		for (SystemRoleMenu roleMenu : list) {
			roleMenuDao.del(roleMenu);
		}
		List<SystemRolePermission> permissionList = rolePermissionDao.findByHQL("FROM SystemRolePermission WHERE roleId = ?", new Object[] { roleId });
		for (SystemRolePermission permission : permissionList) {
			rolePermissionDao.del(permission);
		}
		System.out.println("menuIds:::" + menuIds);
		if (menuIds != null) {
			System.out.println("保存");
			for (String menuId : menuIds) {
				SystemRoleMenu roleMenu = new SystemRoleMenu();
				Integer id = null;
				if (menuId.contains("menu")) {
					id = Integer.valueOf(menuId.replace("menu", ""));
					roleMenu.setParentId(0);
				} else {
					id = Integer.valueOf(menuId.replace("subMenu", ""));
					SystemMenu menu = menuService.getMenuById(id);
					roleMenu.setParentId(menu.getParentId());
				}
				if (id == null) {
					throw new Exception("menuId 添加时不能为 null");
				}
				roleMenu.setMenuId(id);
				roleMenu.setRoleId(roleId);
				roleMenuDao.save(roleMenu);
			}
		}
		if (permIds != null) {
			for (String permId : permIds) {
				int id = Integer.valueOf(permId.replace("perm", ""));
				SystemRolePermission rolePermission = new SystemRolePermission();
				rolePermission.setPermissionId(id);
				rolePermission.setRoleId(roleId);
				rolePermissionDao.save(rolePermission);
			}
		}
		return true;
	}

	@Override
	public SystemRoleMenu getRoleMenu(Integer roleId, Integer menuId) {
		SystemRoleMenu roleMenu = null;
		roleMenu = roleMenuDao.findObjectByHQL("FROM SystemRoleMenu WHERE roleId = ? AND menuId = ?", new Object[] { roleId, menuId });
		return roleMenu;
	}

	@Override
	public SystemRolePermission getRolePermission(Integer roleId, Integer permissionId) {
		SystemRolePermission rolePermission = null;
		rolePermission = rolePermissionDao.findObjectByHQL("FROM SystemRolePermission WHERE roleId = ? AND permissionId = ?", new Object[] { roleId, permissionId });
		return rolePermission;
	}

	@Override
	public List<SystemPermission> getPermissionList() {
		List<SystemPermission> list = null;
		list = permissionDao.findByHQL("FROM SystemPermission");
		return list;
	}

}
