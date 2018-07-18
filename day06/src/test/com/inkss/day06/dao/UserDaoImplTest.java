package com.inkss.day06.dao;

import com.inkss.day06.pojo.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    private UserDao userDao = new UserDaoImpl();

    @Test
    public void insertUser() {

        User user = new User("小黄", new Date(), "男", "中国");
        System.out.println("新插入的用户 ID 为：" + userDao.insertUser(user));

    }

    @Test
    public void deleteUser() {
        if (userDao.deleteUser(1))
            System.out.println("成功");
        else
            System.out.println("失败");
    }

    @Test
    public void deleteByIDList() {
        List<Integer> list = new ArrayList<>();
        list.add(32);
        list.add(33);
        if (userDao.deleteByIDList(list))
            System.out.println("成功");
        else
            System.out.println("失败");
    }

    @Test
    public void updateUser() {
        if (userDao.updateUser(new User(33, "小黄儿", new Date(), "男", "中国")))
            System.out.println("成功");
        else
            System.out.println("失败");
    }

    @Test
    public void selectLikeName() {
        List<User> userList = userDao.selectLikeName("张");

        for (User user : userList)
            System.out.println(user);
    }

    @Test
    public void selectAllUser() {

        List<User> userList = userDao.selectAllUser();

        for (User user : userList)
            System.out.println(user);
    }

    @Test
    public void selectById() {
        System.out.println(userDao.selectById(10));
    }

    @Test
    public void selectByName() {
        System.out.println(userDao.selectByName("陈小明"));
    }
}