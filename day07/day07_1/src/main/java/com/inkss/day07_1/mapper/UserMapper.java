package com.inkss.day07_1.mapper;

import com.inkss.day07_1.pojo.User;

import java.util.List;

public interface UserMapper {

    void insertUser(User user);

    boolean updateUser(User user);

    List<User> selectBySexAndName(User user);
}
