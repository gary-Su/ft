package com.website.ft.admin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.website.ft.model.Product;
import com.website.ft.service.ProductService;
import com.website.ft.util.DateUtil;
import com.website.ft.util.Page;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
	@Value("${image-store-path}")
	private String imageStorePath;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value= {"","/list"})
	public String list(@ModelAttribute(value="product") Product product,ModelMap map) {
		Page<Product> page  = productService.findPage(product);
		map.put("page", page);
		map.put("code", "0");
		map.put("msg", "获取列表成功");
		return "/admin/products";
	}
	@RequestMapping(value= "/add", method=RequestMethod.POST)
	public String add(@ModelAttribute(value="product") Product product,ModelMap map) {
		int result  = productService.insert(product);
		Page<Product> page  = productService.findPage(product);
		map.put("page", page);
		map.put("result", result);
		map.put("code", "0");
		map.put("msg", "添加数据成功");
		return "/admin/products";
	}
	
	@RequestMapping(value= {"/uploadImage"})
	@ResponseBody
	public Map<String, Object> upload(HttpServletRequest request) {
		 HashMap<String, Object> map = new HashMap<>();
		 List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
		 MultipartFile file = null;
	        BufferedOutputStream stream = null;
	        for (int i = 0; i < files.size(); i++) { 
	            file = files.get(i); 
	            if (!file.isEmpty()){
	                try {
	                	String fileName = file.getOriginalFilename();
	                	int index = fileName.indexOf(".");
	                	String suffix = fileName.substring(index, fileName.length());
	                	String name = DateUtil.getCurrDateStr("yyyyMMddHHmmssSSS")+suffix;
	                    byte[] bytes = file.getBytes(); 
	                    String path = imageStorePath+name;
	                    stream = new BufferedOutputStream(new FileOutputStream(new File(path))); 
	                    stream.write(bytes); 
	                    stream.close();
	                    map.put("img"+(i+1), path);
	                } catch (Exception e) {
	                	e.printStackTrace();
	                    stream =  null;
	                    map.put("code", "1");
		    			map.put("msg", "上传失败 => " + e.getMessage());
	                } 
	                map.put("code", "0");
	    			map.put("msg", "上传成功");
	            } else {
	                map.put("code", "1");
	    			map.put("msg", "上传失败,文件为空");
	            } 
	        } 
	        return map;
	}
	
	@RequestMapping(value= {"/toAdd"})
	public String toAdd(@ModelAttribute(value="product")Product product,ModelMap map) {
		return "/admin/product";
	}
	
	@RequestMapping(value= {"/toUpdate"})
	public String toUpdate(@ModelAttribute(value="product")Product product,ModelMap map) {
		Integer id = product.getId();
		product = productService.selectByPrimaryKey(id);
		map.put("product", product);
		return "/admin/product";
	}
	
	
	
}
