package com.inkss.day07_3.mapper;

import com.inkss.day07_3.pojo.User;
import com.inkss.day07_3.pojo.UserPojo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "SqlMapConfig.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findUserList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserPojo userPojo = new UserPojo();

        User user = new User();
        user.setSex("男");
        user.setUsername("小");

        userPojo.setUser(user);

        List<User> userList = userMapper.findUserList(userPojo);

        for (User user1 : userList)
            System.out.println(user1);
    }

    @Test
    public void deleteByIdList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> list = new ArrayList<>();
        list.add(45);
        list.add(47);
        list.add(46);

        UserPojo userPojo = new UserPojo();
        userPojo.setIdList(list);

        userMapper.deleteByIdList(userPojo);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void findCountByName() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("小");
        System.out.println(userMapper.findCountByName(user));

    }
}