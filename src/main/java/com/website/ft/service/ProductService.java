package com.website.ft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.ft.dao.ProductMapper;
import com.website.ft.model.Product;

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
	    
	    public List<Product> selectAll() {
			return productMapper.selectAll();
		}

	    public int updateByPrimaryKeySelective(Product record) {
			return productMapper.updateByPrimaryKeySelective(record);
		}

	    public int updateByPrimaryKey(Product record) {
			return productMapper.updateByPrimaryKey(record);
		}
}
