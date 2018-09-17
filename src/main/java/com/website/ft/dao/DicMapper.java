package com.website.ft.dao;

import java.util.List;

import com.website.ft.model.Dic;

public interface DicMapper {
	
	public int deleteByPrimaryKey(Integer id);

    public int insert(Dic record);

    public int insertSelective(Dic record);

    public Dic selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(Dic record);

    public int updateByPrimaryKey(Dic record);
    
    public int selectAllCount();
    
    public List<Dic> selectAll(Dic record);
}