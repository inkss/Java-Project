package com.inkss.day05_3.pojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class UserTest {

    @Test
    public void selectAllUser() throws IOException {
        System.out.println("测试开始");

        // 在类中访问库
        // 先加载 mybatis 配置文件
        String path = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(path);

        // 生成 sql 会话工厂类对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取 SqlSession 对象：也就是一次 sql 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 使用 sqlSession 进行 sql 查询
        // selectList 是查询集合数据
        List<User> userList = sqlSession.selectList("UserMapper.selectAllUser");

        for (User user : userList)
            System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void selectById() throws IOException {
        System.out.println("测试开始");
        String path = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("UserMapper.selectById", 26);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void selectByName() throws IOException {
        System.out.println("测试开始");
        String path = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("UserMapper.selectByName", "张三");
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void selectLikeName() throws IOException {
        System.out.println("测试开始");
        String path = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("UserMapper.selectLikeName", "张");
        for (User user : userList)
            System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void insertUser() throws IOException {
        System.out.println("测试开始");
        String path = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User("小红", new Date(), "男", "");

        sqlSession.insert("UserMapper.insertUser", user);
        sqlSession.commit(); // 提交
        System.out.println("插入的 id 为：" + user.getId());
        sqlSession.close();
    }

    @Test
    public void updateUser() throws IOException {
        System.out.println("测试开始");
        String path = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User(29,"小红哟", new Date(), "女", "三里屯");

        sqlSession.update("UserMapper.updateUser", user);
        sqlSession.commit(); // 提交
        sqlSession.close();
    }

}