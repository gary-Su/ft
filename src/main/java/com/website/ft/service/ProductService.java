package com.website.ft.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.ft.dao.ProductMapper;
import com.website.ft.model.Product;
import com.website.ft.util.Page;

@Service
public class ProductService {
		@Autowired
		private ProductMapper productMapper;
	
		public int deleteByPrimaryKey(Integer id) {
			return productMapper.deleteByPrimaryKey(id);
		}

	 	public int insert(Product record) {
			return productMapper.insert(record);
		}

	    public int insertSelective(Product record) {
			return productMapper.insertSelective(record);
		}

	    public Product selectByPrimaryKey(Integer id) {
			return productMapper.selectByPrimaryKey(id);
		}
	    
	    public List<Product> selectAll(Product product) {
			return productMapper.selectAll(product);
		}
	    
		public Page<Product> findPage(Product product) {
			int pageNo = product.getPageNo();
			int pageSize = product.getPageSize();
	    	int count = productMapper.selectAllCount();
	    	product.setPageNo((pageNo-1)*pageSize);
	    	List<Product> list = productMapper.selectAll(product);
	    	Page<Product> page = new Page<Product>(pageNo,pageSize,count);
	    	page.setList(list);
	    	return page;
	    	
	    }

	    public int updateByPrimaryKeySelective(Product record) {
			return productMapper.updateByPrimaryKeySelective(record);
		}

	    public int updateByPrimaryKey(Product record) {
			return productMapper.updateByPrimaryKey(record);
		}
}
