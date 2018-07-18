package com.inkss.day07_1.mapper;

import com.inkss.day07_1.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> selectLikeName(String name);

    List<User> selectNameAndSex(String name,String sex);

    //  使用动态 sql 多条件查询
    public List<User> selectByIdAndName(User user);
}
