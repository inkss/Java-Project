package com.inkss.day05_3.pojo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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
    }


}