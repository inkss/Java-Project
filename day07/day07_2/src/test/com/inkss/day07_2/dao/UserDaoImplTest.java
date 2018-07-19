package com.inkss.day07_2.dao;

import com.inkss.day07_2.pojo.User;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserDaoImplTest {

    private UserDao userDao = new UserDaoImpl();

    @Test
    public void insertUser() {

        User user = new User("小黄123", new Date(), "男", "中国");
        System.out.println("新插入的用户 ID 为：" + userDao.insertUser(user));

    }

    @Test
    public void updateUser() {
        if (userDao.updateUser(new User(34, "小黄儿111ii", new Date(), "男", "中国")))
            System.out.println("成功");
        else
            System.out.println("失败");
    }

    @Test
    public void selectBySexAndName() {
        User user = new User();
        user.setUsername("小");
        user.setSex("男");
        List<User> userList = userDao.selectBySexAndName(user);

        for (User u : userList)
            System.out.println(u);
    }

}