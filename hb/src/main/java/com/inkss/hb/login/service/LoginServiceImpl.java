package com.inkss.hb.login.service;

import com.inkss.hb.common.MD5;
import com.inkss.hb.login.mapper.LoginMapper;
import com.inkss.hb.login.pojo.Login;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class LoginServiceImpl implements LoginService {

    private static SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession = null;
    private LoginMapper loginMapper = null;
    private MD5 md5 = new MD5();

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
    public int queryByName(String name, String pwd) {
        sqlSession = sqlSessionFactory.openSession();
        loginMapper = sqlSession.getMapper(LoginMapper.class);

        Login checkLogin = loginMapper.queryByName(name);
        sqlSession.close();

        //密码转MD5加密存储
        String pwd1 = md5.getMD5(pwd);

        if (checkLogin == null)
            return -1;
        else if (checkLogin.getLoginPwd().equals(pwd1))
            return 1;
        else
            return 0;
    }

    @Override
    public Login queryLogin(String name) {
        sqlSession = sqlSessionFactory.openSession();
        loginMapper = sqlSession.getMapper(LoginMapper.class);

        Login login = loginMapper.queryByName(name);
        sqlSession.close();
        return login;
    }

    @Override
    public boolean insertLogin(Login login) {
        if (queryLogin(login.getLoginName()) == null) {
            sqlSession = sqlSessionFactory.openSession();
            loginMapper = sqlSession.getMapper(LoginMapper.class);

            //密码转MD5加密存储
            String pwd = login.getLoginPwd();
            login.setLoginPwd(md5.getMD5(pwd));

            loginMapper.insertData(login);
            sqlSession.commit();
            sqlSession.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteLogin(int loginId) {
        sqlSession = sqlSessionFactory.openSession();
        loginMapper = sqlSession.getMapper(LoginMapper.class);
        try {
            loginMapper.deleteData(5);
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.commit();
        }
    }

    @Override
    public boolean updateLogin(Login login) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            loginMapper = sqlSession.getMapper(LoginMapper.class);

            //密码转MD5加密存储
            String pwd = login.getLoginPwd();
            login.setLoginPwd(md5.getMD5(pwd));

            loginMapper.updateData(login);
            sqlSession.commit();
            sqlSession.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Login> query(int page, int limit) {

        int start = (page * limit) - limit; //每一页的起始位置
        if (start < 0)  //小于0的话会触发一个错误
            start = 0;  //但是理论上page和limit是由table表格生成的参数

        try {
            sqlSession = sqlSessionFactory.openSession();
            loginMapper = sqlSession.getMapper(LoginMapper.class);
            return loginMapper.queryList(start, limit);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public int queryLoginNum() {
        sqlSession = sqlSessionFactory.openSession();
        loginMapper = sqlSession.getMapper(LoginMapper.class);
        int num = loginMapper.queryDataNum();
        sqlSession.close();
        return num;
    }
}
