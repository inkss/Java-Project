package com.inkss.day06.dao;

import com.inkss.day06.pojo.User;
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
        int flag = user.getId();
        sqlSession.commit();
        sqlSession.close();
        return flag;
    }

    @Override
    public boolean deleteUser(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("UserMapper.deleteUser", id);
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
    public boolean deleteByIDList(List<Integer> list) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("UserMapper.deleteByIDList", list);
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
    public List<User> selectLikeName(String userName) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("UserMapper.selectLikeName", userName);
        sqlSession.close();
        return userList;
    }

    @Override
    public List<User> selectAllUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("UserMapper.selectAllUser");
        sqlSession.close();
        return userList;
    }

    @Override
    public User selectById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("UserMapper.selectById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public User selectByName(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("UserMapper.selectByName", username);
        sqlSession.close();
        return user;
    }

}
