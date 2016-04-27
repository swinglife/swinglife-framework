package com.lepu.system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lepu.dao.impl.CommonDao;
import com.lepu.system.model.SystemPermission;
import com.lepu.system.model.SystemRole;
import com.lepu.system.model.SystemUser;
import com.lepu.system.model.SystemUserRole;

@Service
public class SystemUserService {

	@Autowired
	private CommonDao<SystemUser> userDao;

	@Autowired
	private CommonDao<SystemPermission> permissionDao;

	public SystemUser getUserByUsername(String username) {
		SystemUser user = null;
		user = userDao.findObjectByHQL("FROM SystemUser WHERE username = ?", new Object[] { username });
		return user;
	}

	public Integer getRoleIdByUser(Integer userId) {
		Integer roleId = null;
		System.out.println("userId::"+userId);
		SystemUser user = userDao.findObjectByHQL("FROM SystemUser WHERE id = ?", new Object[] { userId });
		System.out.println("user::::::"+user);
		roleId = user.getUserRoles().get(0).getSystemRole().getId();
		return roleId;
	}

	public List<String> getPermissionsByUserName(String username) {
		SystemUser user = getUserByUsername(username);
		if (user == null) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		for (SystemUserRole userRole : user.getUserRoles()) {
			System.out.println("userRole:" + userRole);
			SystemRole role = userRole.getSystemRole();
			System.out.println("role:" + role);
			List<SystemPermission> permissions = permissionDao.findByHQL("FROM SystemPermission WHERE roleId = ?", new Object[] { role.getId() });
			System.out.println(permissions);
			for (SystemPermission p : permissions) {
				System.out.println(p.getUrl());
				list.add(p.getUrl());
			}
		}
		return list;
	}

	public SystemUser getUserById(int id) {
		SystemUser user = null;
		user = userDao.get(SystemUser.class, id);
		return user;
	}

}
