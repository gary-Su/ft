package com.website.ft.dao;

import com.website.ft.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    User selectByName(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}