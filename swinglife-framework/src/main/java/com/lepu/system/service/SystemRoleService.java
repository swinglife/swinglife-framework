package com.lepu.system.service;

import java.util.List;

import com.lepu.system.model.SystemRole;
import com.lepu.system.model.SystemRoleMenu;
import com.lepu.system.model.SystemRolePermission;

public interface SystemRoleService {

	/****
	 * 获取所有角色列表
	 * @return
	 */
	public List<SystemRole> getAllRoleList();

	/****
	 * 编辑角色权限和菜单
	 * @param roleId
	 * @param menuIds
	 * @param perms
	 * @return
	 */
	public boolean editRoleMenuAndPermission(Integer roleId, String[] menuIds, String[] perms) throws Exception;

	/****
	 * 获取角色菜单
	 * @param roleId
	 * @param menuId
	 * @return
	 */
	public SystemRoleMenu getRoleMenu(Integer roleId, Integer menuId);

	/****
	 * 获取角色权限 
	 * @param roleId
	 * @param permissionId
	 * @return
	 */
	public SystemRolePermission getRolePermission(Integer roleId, Integer permissionId);

}
