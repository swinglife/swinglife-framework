package com.lepu.system.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.lepu.system.model.SystemMenu;
import com.lepu.system.service.SystemMenuService;

@Controller
@RequestMapping("system/menu")
public class MenuController {

	@Autowired
	private SystemMenuService menuService;

	@RequestMapping("editMenu")
	@ResponseBody
	public Map editMenu(String name, String description, Integer menuId, String url, Integer parentId, String icon) {
		Map result = new HashMap();
		SystemMenu menu = new SystemMenu();
		System.out.println("menuId::" + menuId);
		menu.setName(name);
		menu.setDescription(description);
		menu.setId(menuId);
		menu.setParentId(parentId);
		menu.setIcon(icon);
		menu.setUrl(url);
		if (menu != null) {
			menuService.updateMenu(menu);
		}
		result.put("code", 1);
		return result;
	}

	@RequestMapping("getMenu")
	@ResponseBody
	public Map getMenu(Integer menuId) {
		Map result = new HashMap();
		SystemMenu menu = menuService.getMenuById(menuId);
		result.put("menu", menu);
		result.put("code", 1);
		return result;
	}

	@RequestMapping("delSubMenu")
	@ResponseBody
	public Object delSubMenu(Integer id) {
		Map reuslt = new HashMap();
		menuService.deleteMenu(id);
		reuslt.put("code", 1);
		return reuslt;
	}

	@RequestMapping("getSubMenuList")
	@ResponseBody
	public Map getSubMenuList(Integer menuId) {
		Map<String, Object> result = new HashMap();
		try {
			List<SystemMenu> list = menuService.getSubMenu(menuId);
			result.put("list", list);
			result.put("code", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("getParentMenu")
	@ResponseBody
	public Object getParentMenu(HttpSession session) {
		Integer userId = (Integer) session.getAttribute("USERID");
		List<SystemMenu> list = menuService.getParentMenuByUser(userId);
		Map result = new HashMap();
		List menuList = new ArrayList();
		for (SystemMenu menu : list) {
			Map map = new HashMap();
			map.put("name", menu.getName());
			map.put("icon", menu.getIcon());
			map.put("url", menu.getUrl());
			menuList.add(map);
		}
		result.put("code", 1);
		result.put("list", menuList);
		return result;
	}

	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("menu/list");
		List list = menuService.getParentMenu();
		mav.addObject("subMenu", "menuList");
		mav.addObject("list", list);
		mav.addObject("menu", "system");
		return mav;
	}

	@RequestMapping("add")
	@ResponseBody
	public Object add(SystemMenu menu) {
		Map result = new HashMap();
		if (menu == null && menu.getName() == null && menu.getDescription() == null) {
			result.put("code", 2);
			result.put("errMsg", "参数异常");
			return result;
		}
		menu.setCreateTime(new Date());
		menu.setUpdateTime(new Date());
		menuService.addMenu(menu);
		result.put("code", 1);
		return result;
	}

}
