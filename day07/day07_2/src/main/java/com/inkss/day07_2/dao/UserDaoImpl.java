package com.inkss.day07_2.dao;

import com.inkss.day07_2.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements UserDao {

    // 实现类
    private static SqlSessionFactory sqlSessionFactory;

    // 静态快
    static {
        String resource = "SqlMapConfig.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("UserMapper.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
        return user.getId();
    }

    @Override
    public boolean updateUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.update("UserMapper.updateUser", user);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Override
    public List<User> selectBySexAndName(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("UserMapper.selectBySexAndName",user);
        return userList;
    }
}
