package com.website.ft.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.website.ft.model.Product;
import com.website.ft.service.ProductService;
import com.website.ft.util.Page;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value= {"","/list"})
	public String list(HttpServletRequest request, HttpServletResponse response,ModelMap map) {
		Page page  = productService.findPage(new Page<Product>(request, response), null);
		map.put("page", page);
		map.put("code", "0");
		map.put("msg", "获取列表成功");
		
		return "/admin/products";
	}
	
}
