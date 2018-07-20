package com.inkss.hb.login.service;

import com.inkss.hb.login.pojo.Login;

import java.sql.SQLException;
import java.util.List;

public interface LoginService {

    /**
     * 根据name和pwd返回判断结果
     *
     * @param name 登录名
     * @param pwd  登录密码
     * @return 0：密码错误；1：登录成功；-1：账户不存在
     * @throws SQLException 数据库错误
     */
    int queryByName(String name, String pwd);

    /**
     * 根据name返回Login对象
     *
     * @param name 登录名
     * @return Login对象
     * @throws SQLException 数据库错误
     */
    Login queryLogin(String name);

    //增添
    boolean insertLogin(Login login);

    //删除
    boolean deleteLogin(int loginId);

    //更新
    boolean updateLogin(Login login);

    //查询多条
    List<Login> query(int page, int limit);

    //查询长度
    int queryLoginNum();

}
