package com.inkss.hb.login.mapper;

import com.inkss.hb.login.pojo.Login;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LoginMapperTest {

    private static SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession = null;
    private LoginMapper loginMapper = null;

    static {
        String resource = "SqlMapConfig.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before() {
        sqlSession = sqlSessionFactory.openSession();
        loginMapper = sqlSession.getMapper(LoginMapper.class);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertData() {

        Login login = new Login("测试", "123456", "测试用户");

        loginMapper.insertData(login);
        System.out.println("新用户的 ID 为：" + login.getLoginId());
    }

    @Test
    public void deleteData() {

        Login login = new Login();
        login.setLoginId(2);

        loginMapper.deleteData(4);
    }

    @Test
    public void updateData() {

        Login login = new Login(3, "测试更新", "123456", "测试用户", 1);
        loginMapper.updateData(login);
    }

    @Test
    public void queryDataNum() {

        System.out.println("用户个数：" + loginMapper.queryDataNum());
    }

    @Test
    public void queryList() {

        List<Login> loginList = loginMapper.queryList(0, 1);
        System.out.println(loginList);
    }

    @Test
    public void queryByName() {

        System.out.println(loginMapper.queryByName("测"));
    }


}