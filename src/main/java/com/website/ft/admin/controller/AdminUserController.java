package com.website.ft.admin.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.website.ft.model.Result;
import com.website.ft.model.User;
import com.website.ft.service.UserService;
import com.website.ft.util.MD5;

@Controller
@RequestMapping("/admin")
public class AdminUserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public String init() {
		return "/admin/signIn";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "/admin/index";
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST, headers = "Content-Type=application/json")
	@ResponseBody
	public Result login(@RequestBody HashMap<String, Object> map) {
		Result result = new Result();
		String username = (String) map.get("username");
		String password = (String) map.get("password");
		User user = userService.selectByName(username);
		if(user == null) {
			result.setMsg("用户不存在");
			result.setCode("0");
			return result;
		}else {
			String pwd = user.getPassword();
			password = MD5.md5(password);
			if(pwd.equals(password)) {
				result.setMsg("登录成功");
				result.setCode("1");
				return result;
			}else {
				result.setMsg("密码错误");
				result.setCode("0");
				return result;
			}
		}
	}
	
	@RequestMapping("/register")
	public String register(@RequestParam(value="username1",required = false) String username1,@RequestParam(value="password1",required = false) String password1,@RequestParam(value="password2",required = false) String password2,RedirectAttributes attr) {
		User user = new User();
		if(password1.equals(password2)) {
			user.setPassword(password1);
		}else {
			
		}
		user.setUsername(username1);
		user.setCreatedate(new Date());
		user.setCreateby("admin");
		user.setType(1);
		user.setEmail("xx@qqq.com");
		int result = userService.insert(user);
		if(result == 1) {
			attr.addFlashAttribute("msg", "注册成功");
		}else {
			attr.addFlashAttribute("msg", "注册失败");
		}
		return "redirect:/admin";
	}

}
