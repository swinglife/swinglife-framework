package com.lepu.system.security;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;

import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.lepu.system.model.SystemPermission;
import com.lepu.system.service.SystemPermissionService;

public class SercurityUrlFilterChainDefinition implements FactoryBean<Ini.Section> {

	@Autowired
	private SystemPermissionService permissionService;

	private String defaultFilterChainDefinitions;

	public static final String PREMISSION_STRING = "perms[\"{0}\"]";

	public Section getObject() throws Exception {
		System.out.println("加载权限...");
		List<SystemPermission> list = permissionService.getPermissionList();
		Ini ini = new Ini();
		// 加载默认的url
		ini.load(defaultFilterChainDefinitions);
		Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		for (Iterator<SystemPermission> it = list.iterator(); it.hasNext();) {
			SystemPermission permission = it.next();
			section.put(permission.getUrl(), MessageFormat.format(PREMISSION_STRING, permission.getPermission()));
			System.out.println("permissionName:" + permission.getName());
			System.out.println("permission:" + permission.getPermission());
		}
		return section;
	}

	public Class<?> getObjectType() {
		return null;
	}

	public boolean isSingleton() {
		return false;
	}

	public String getDefaultFilterChainDefinitions() {
		return defaultFilterChainDefinitions;
	}

	public void setDefaultFilterChainDefinitions(String defaultFilterChainDefinitions) {
		this.defaultFilterChainDefinitions = defaultFilterChainDefinitions;
	}

}
