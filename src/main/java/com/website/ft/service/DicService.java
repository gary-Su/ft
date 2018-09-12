package com.website.ft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.ft.dao.DicMapper;
import com.website.ft.model.Dic;
import com.website.ft.util.Page;

@Service
public class DicService {
	@Autowired
	private DicMapper DicMapper;
	
	public int deleteByPrimaryKey(Integer id) {
		return DicMapper.deleteByPrimaryKey(id);
	};

	public int insert(Dic record) {
		return DicMapper.insert(record);
	};

	public int insertSelective(Dic record) {
		return DicMapper.insertSelective(record);
	};

	public Dic selectByPrimaryKey(Integer id) {
		return DicMapper.selectByPrimaryKey(id);
	};

	public int updateByPrimaryKeySelective(Dic record) {
		return DicMapper.updateByPrimaryKeySelective(record);
	};

	public int updateByPrimaryKey(Dic record) {
		return DicMapper.updateByPrimaryKey(record);
	};
	
	public Page<Dic> findPage(Dic record) {
		int pageNo = record.getPageNo();
		int pageSize = record.getPageSize();
    	int count = DicMapper.selectAllCount();
    	record.setPageNo((pageNo-1)*pageSize);
    	List<Dic> list = DicMapper.selectAll(record);
    	Page<Dic> page = new Page<Dic>(pageNo,pageSize,count);
    	page.setList(list);
    	return page;
    	
    }
}
