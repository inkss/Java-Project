package com.inkss.day07_1.mapper;

import com.inkss.day07_1.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

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
    public void insertUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User("小黄1223", new Date(), "男", "中国");
        userMapper.insertUser(user);
        sqlSession.commit();
        System.out.println(user.getId()); // 主键值
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(34, "小黄儿12333", new Date(), "男", "中国");
        boolean flag = userMapper.updateUser(user);
        sqlSession.commit();
        if (flag)
            System.out.println("成功");
        else
            System.out.println("失败");
        sqlSession.close();
    }

    @Test
    public void selectBySexAndName() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("小");
        user.setSex("男");

        List<User> userList = userMapper.selectBySexAndName(user);

        for (User u : userList)
            System.out.println(u);
        sqlSession.close();
    }
}