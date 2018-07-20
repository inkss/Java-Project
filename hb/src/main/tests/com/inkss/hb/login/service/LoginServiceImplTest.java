package com.inkss.hb.login.service;

import com.inkss.hb.login.pojo.Login;
import org.junit.Test;

import java.util.List;

public class LoginServiceImplTest {

    private LoginService service = new LoginServiceImpl();

    @Test
    public void queryByName() {
        System.out.println(service.queryByName("测试", "123456"));
    }

    @Test
    public void queryLogin() {
        System.out.println(service.queryLogin("测试123"));
    }

    @Test
    public void insertLogin() {

        Login login = null;

        for (int i = 0; i < 20; i++) {
            login = new Login("测试132" + i, "123456", "测试用户");
            service.insertLogin(login);
        }

    }

    @Test
    public void deleteLogin() {
        System.out.println(service.deleteLogin(4));
    }

    @Test
    public void updateLogin() {
        Login login = new Login(33, "测试132", "123456", "测试用户", 0);
        System.out.println(service.updateLogin(login));
    }

    @Test
    public void query() {
        List<Login> loginList = service.query(2,3);
        for (Login l : loginList) {
            System.out.println(l);
        }
    }

    @Test
    public void queryLoginNum() {
        System.out.println(service.queryLoginNum());
    }
}