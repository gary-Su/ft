package com.website.ft.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.website.ft.model.User;
import com.website.ft.service.UserService;
import com.website.ft.util.MD5;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public String init() {
		return "/admin/login";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "/admin/index";
	}
	
	
	@RequestMapping("/login")
	public String login(@ModelAttribute User user,ModelMap modelMap) {
		String username = user.getUsername();
		String password = user.getPassword();
		user = userService.selectByName(username);
		if(user == null) {
			modelMap.put("msg", "用户不存在");
			return "redirect:/admin";
		}else {
			String pwd = user.getPassword();
			password = MD5.md5(password);
			if(pwd.equals(password)) {
				return "/admin/index";
			}else {
				modelMap.put("msg", "密码错误");
				return "redirect:/admin";
			}
		}
	}

}
