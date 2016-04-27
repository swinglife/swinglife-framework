package com.lepu.system.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.lepu.system.model.SystemMenu;
import com.lepu.system.service.SystemMenuService;
import com.lepu.system.service.SystemRoleService;

@Aspect
public class MenuInterceptor {

	@Autowired
	HttpServletRequest request;

	@Autowired
	SystemMenuService menuService;

	@Autowired
	SystemRoleService roleService;

	@Around("execution(public org.springframework.web.servlet.ModelAndView com.lepu.system.web.controller.*.*(..))")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		Object object = pjp.proceed();
		if (object instanceof ModelAndView) {
			ModelAndView mav = (ModelAndView) object;
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			Integer userId = (Integer) session.getAttribute("USERID");
			System.out.println("userID:"+userId);
			if (userId != null) {
				System.out.println("开始查询");
				System.out.println("开始查询");
				System.out.println("开始查询");
				System.out.println("开始查询");
				System.out.println("开始查询");
				System.out.println("开始查询");
				System.out.println("开始查询");
				List<SystemMenu> menuList = menuService.getParentMenuByUser(userId);
				mav.addObject("leftParentMenu", menuList);
			}
		}
		return object;
	}

	@Around("execution(public String com.lepu.system.web.controller.*.*(..))")
	public Object doBasicProfilingString(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Request:" + request);
		Object object = pjp.proceed();// 执行该方法
		return object;
	}
}
