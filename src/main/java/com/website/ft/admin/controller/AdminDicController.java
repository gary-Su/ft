package com.website.ft.admin.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.website.ft.model.Dic;
import com.website.ft.service.DicService;
import com.website.ft.util.Page;

@Controller
@RequestMapping("/admin/dic")
public class AdminDicController {
	@Autowired
	private DicService dicService;
	
	@RequestMapping(value= {"","/list"})
	public String list(@ModelAttribute(value="dic") Dic dic,ModelMap map) {
		Page<Dic> page  = dicService.findPage(dic);
		map.put("page", page);
		map.put("code", "0");
		map.put("msg", "获取列表成功");
		return "/admin/dics";
	}
	@RequestMapping(value= "/addOrUpdate", method=RequestMethod.POST)
	public String add(@ModelAttribute(value="dic") Dic dic,ModelMap map) {
		Integer id = dic.getId();
		int result = 0;
		if(id == null) {
			dic.setCreatedate(new Date());
			dic.setCreateby("1");
			result  = dicService.insert(dic);
			map.put("msg", "添加数据成功");
		}else {
			dic.setUpdatedate(new Date());
			dic.setUpdateby("1");
			result  = dicService.updateByPrimaryKeySelective(dic);
			map.put("msg", "更新数据成功");
		}
		Page<Dic> page  = dicService.findPage(dic);
		map.put("page", page);
		map.put("result", result);
		map.put("code", "0");
		
		return "/admin/dics";
	}
	
	@RequestMapping(value= {"/toAdd"})
	public String toAdd(@ModelAttribute(value="dic") Dic dic,ModelMap map) {
		return "/admin/dic";
	}
	
	@RequestMapping(value= {"/toUpdate"})
	public String toUpdate(@ModelAttribute(value="dic")Dic dic,ModelMap map) {
		Integer id = dic.getId();
		dic = dicService.selectByPrimaryKey(id);
		map.put("dic", dic);
		return "/admin/dic";
	}
	
	@RequestMapping(value= {"/toDelete"})
	public String toDelete(@ModelAttribute(value="dic")Dic dic,ModelMap map) {
		dic.setDelflag(0);
		dic.setUpdatedate(new Date());
		dic.setUpdateby("1");
		int result  = dicService.updateByPrimaryKeySelective(dic);
		map.put("result", result);
		map.put("msg", "更新数据成功");
		return "/admin/dic";
	}
	
	
	
	
}
