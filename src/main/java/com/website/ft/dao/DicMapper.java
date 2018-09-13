package com.website.ft.dao;

import java.util.List;

import com.website.ft.model.Dic;

public interface DicMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Dic record);

    int insertSelective(Dic record);

    Dic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dic record);

    int updateByPrimaryKey(Dic record);
    
    int selectAllCount();
    
    List<Dic> selectAll(Dic record);
}