package com.lepu.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lepu.dao.impl.CommonDao;
import com.lepu.system.model.SystemPermission;

@Service
public class SystemPermissionService {
	
	@Autowired
	private CommonDao<SystemPermission> permissionDao;
	
	public List<SystemPermission> getPermissionList(){
		List<SystemPermission> list = null;
		list = permissionDao.findByHQL("FROM SystemPermission");
		return list;
	}
}
