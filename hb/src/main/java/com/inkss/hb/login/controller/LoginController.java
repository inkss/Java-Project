package com.inkss.hb.login.controller;

import com.inkss.hb.login.service.LoginService;
import com.inkss.hb.login.service.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("QueryLoginName")
public class LoginController {

    private LoginService service = new LoginServiceImpl();

    @RequestMapping("login.do")
    @ResponseBody
    public String toList(String loginName, String loginPwd) {

        String data = String.valueOf(service.queryByName(loginName, loginPwd));

        return data;
    }

}
