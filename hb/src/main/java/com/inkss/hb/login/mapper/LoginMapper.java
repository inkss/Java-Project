package com.inkss.hb.login.mapper;

import com.inkss.hb.login.pojo.Login;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * LoginMapper
 * 提供：
 * 增删改
 * 用户账户密码查询
 * 用户个数查询
 * 用户名查询
 * 范围查询
 */
public interface LoginMapper {

    void insertData(Login login);

    void deleteData(Integer loginId);

    void updateData(Login login);

    int queryDataNum();

    List<Login> queryList(int start, int length);

    Login queryByName(@Param("loginName") String loginName);

}
