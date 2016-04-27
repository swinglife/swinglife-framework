package com.lepu.system.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("system/admin")
public class AdminController {


	@RequestMapping("list")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView("admin/list");
		mav.addObject("menu", "system");
		mav.addObject("subMenu", "adminList");
		return mav;
	}
	
	
	
}
