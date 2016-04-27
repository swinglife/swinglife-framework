package com.lepu.system.security;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.lepu.system.model.SystemUser;
import com.lepu.system.service.SystemUserService;

public class SercurityRealm extends AuthorizingRealm {

	@Autowired
	private SystemUserService userService;

	/****
	 * 获取授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		System.out.println("用户授权信息....................");
		String username = (String) pc.fromRealm(getName()).iterator().next();
		System.out.println("用户登录:username:" + username);
		if (username != null) {
			List<String> pers = userService.getPermissionsByUserName(username);
			if (pers != null && !pers.isEmpty()) {
				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
				for (String each : pers) {
					System.out.println("授权内容:" + each);
					// 将权限资源添加到用户信息中
					info.addStringPermission(each);
				}
				return info;
			}
		}
		return null;
	}

	/***
	 * 获取认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {
		System.out.println("执行.................");
		UsernamePasswordToken token = (UsernamePasswordToken) at;
		// 通过表单接收的用户名
		String username = token.getUsername();
		if (username != null && !"".equals(username)) {
			SystemUser user = userService.getUserByUsername(username);
			if (user != null) {
				return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
			}
		}
		return null;
	}

}
