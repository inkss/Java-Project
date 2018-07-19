package com.inkss.day07_2.dao;

import com.inkss.day07_2.pojo.User;

import java.util.List;

public interface UserDao {

    int insertUser(User user);

    boolean updateUser(User user);

    List<User> selectBySexAndName(User user);

}
