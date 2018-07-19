package com.inkss.day07_3.mapper;

import com.inkss.day07_3.pojo.User;
import com.inkss.day07_3.pojo.UserPojo;

import java.util.List;

public interface UserMapper {

    List<User> findUserList(UserPojo userPojo);

    void deleteByIdList(UserPojo userPojo);

    Integer findCountByName (User user);
}
