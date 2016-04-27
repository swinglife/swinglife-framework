package com.lepu.system.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lepu.system.model.SystemUser;
import com.lepu.system.service.SystemUserService;

@Controller
public class IndexController {

	@Autowired
	private SystemUserService userService;

	@RequestMapping("home")
	public ModelAndView index(ModelMap model) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("login")
	public ModelAndView login(SystemUser systemUser) {
		ModelAndView mav = new ModelAndView();
		System.out.println(systemUser.getUsername());
		System.out.println(systemUser.getPassword());
		SystemUser user = userService.getUserByUsername(systemUser.getUsername());
		if (user == null) {
			System.out.println("用户不存在");
			mav.setViewName("login");
			mav.addObject("msg", "用户不存在");
			return mav;
		}
		if (!user.getPassword().equals(systemUser.getPassword())) {
			System.out.println("账号密码错误");
			mav.setViewName("login");
			mav.addObject("msg", "账号密码错误");
			return mav;
		}
		System.out.println(user.getId());
		SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
		// 登录后存放进shiro token
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.setAttribute("USERID", user.getId());
		subject.login(token);
		System.out.println("登录成功");
		mav.setViewName("redirect:home");
		return mav;
	}

}
