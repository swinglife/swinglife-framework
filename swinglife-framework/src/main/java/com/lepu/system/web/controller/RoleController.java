package com.lepu.system.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lepu.system.model.SystemMenu;
import com.lepu.system.model.SystemRole;
import com.lepu.system.service.SystemMenuService;
import com.lepu.system.service.SystemRoleService;

@Controller
@RequestMapping("system/role")
public class RoleController {

	@Autowired
	SystemRoleService roleService;

	@Autowired
	SystemMenuService menuService;

	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		System.out.println(roleService);
		List<SystemRole> list = roleService.getAllRoleList();
		mav.setViewName("role/list");
		mav.addObject("list", list);
		mav.addObject("subMenu", "roleList");
		mav.addObject("menu", "system");
		return mav;
	}

	@RequestMapping("saveMenu")
	@ResponseBody
	public Object saveMenu(Integer roleId, String[] menuId, String[] permId) {
		Map<String, Object> result = new HashMap();
		try {
			if (roleService.editRoleMenuAndPermission(roleId, menuId, permId)) {
				result.put("code", 1);
			} else {
				result.put("code", 2);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 3);
			result.put("errMsg", "服务器异常");
		}
		return result;
	}

	@RequestMapping("getMenuList")
	@ResponseBody
	public Object getMenuList(Integer roleId) {
		Map<String, Object> result = new HashMap();
		List<Map<String, Object>> list = menuService.getMenuTreeByRoleId(roleId);
		System.out.println(list);
		result.put("list", list);
		result.put("code", 1);
		return result;
	}

}
