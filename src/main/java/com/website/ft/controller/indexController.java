package com.website.ft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.website.ft.model.Product;
import com.website.ft.service.ProductService;

@Controller
public class indexController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/index")
	public String index(ModelMap modelMap) {
		List<Product> list = productService.selectAll(null);
		modelMap.put("list", list);
		return "/index";
	}

}
