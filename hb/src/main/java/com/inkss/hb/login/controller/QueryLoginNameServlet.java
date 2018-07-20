package com.inkss.hb.login.controller;

import com.google.gson.Gson;
import com.inkss.hb.common.MD5;
import com.inkss.hb.login.service.LoginService;
import com.inkss.hb.login.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/QueryLoginNameServlet", name = "QueryLoginNameServlet")
public class QueryLoginNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 调用service
        LoginService service = new LoginServiceImpl();
        MD5 md5 = new MD5();

        // 获得姓名
        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");

        try {
            int check = service.queryByName(loginName, loginPwd);
            if (check == 1) { // 设置session
                HttpSession session = request.getSession();
                session.setAttribute("LoginName", loginName);
                /*Login login = service.queryLogin(loginName);
                //写入登录记录
                LogInfo logInfo = new LogInfo("登录", login.getLoginId(), login.getLoginName());
                LogInfoService logInfoService = new LogInfoServiceImpl();
                logInfoService.insertLogInfo(logInfo);*/
            }
            Gson gson = new Gson();
            out.print(gson.toJson(check));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
