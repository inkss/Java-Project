package com.inkss.hb.login.controller;

import com.google.gson.Gson;
import com.inkss.hb.login.pojo.Login;
import com.inkss.hb.login.service.LoginService;
import com.inkss.hb.login.service.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("LoginController")
public class LoginController {

    private LoginService service = new LoginServiceImpl();

    @RequestMapping("login.do")
    @ResponseBody
    public String toList(String loginName, String loginPwd, HttpSession session) {

        String data = String.valueOf(service.queryByName(loginName, loginPwd));

        if (data.equals("1")) {
            Login login = service.queryLogin(loginName);
            session.setAttribute("loginName", loginName);
            session.setAttribute("loginId", login.getLoginId());
        }

        Gson gson = new Gson();

        return gson.toJson(data);
    }

    @RequestMapping("exitSystem.do")
    @ResponseBody
    public String toList(HttpSession session) {
        session.removeAttribute("loginId");
        session.removeAttribute("loginName");
        session.invalidate();
        return "";
    }


}
