package com.lepu.system.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lepu.system.service.SystemRoleService;

@Controller
@RequestMapping("system/permission")
public class PermissionController {
	
	
	@Autowired
	private SystemRoleService roleService;
	
	@RequestMapping("list")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView("permission/list");
		List list = roleService.getPermissionList();
		mav.addObject("list", list);
		return mav;
	}

}
