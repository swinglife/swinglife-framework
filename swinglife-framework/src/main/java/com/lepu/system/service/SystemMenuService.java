package com.lepu.system.service;

import java.awt.Menu;
import java.util.List;
import java.util.Map;

import com.lepu.system.model.SystemMenu;

public interface SystemMenuService {

	public List<SystemMenu> getAllMenuList();

	public List<Map<String, Object>> getMenuTreeByRoleId(Integer roleId);

	public void addMenu(SystemMenu menu);

	public List<SystemMenu> getParentMenu();

	public List<SystemMenu> getSubMenu(Integer menuId);
	
	public SystemMenu getMenuById(Integer menuId);

	/***
	 * 获取用户授权的一级菜单
	 * @param userId
	 * @return
	 */
	public List<SystemMenu> getParentMenuByUser(Integer userId);

	/****
	 * 获取用户授权的子菜单
	 * @param userId
	 * @param parentId
	 * @return
	 */
	public List<SystemMenu> getSubMenuByUser(Integer userId, Integer parentId);
	
	
	public void deleteMenu(Integer menuId);
}
