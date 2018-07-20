package com.inkss.hb.login.controller;

import com.google.gson.Gson;
import com.inkss.hb.login.pojo.Login;
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

@WebServlet(value = "/QueryLoginInfoServlet", name = "QueryLoginInfoServlet")
public class QueryLoginInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 调用service
        LoginService service = new LoginServiceImpl();

        // 对于此功能，就直接从session中取值
        HttpSession session = request.getSession();
        String loginName = (String) session.getAttribute("LoginName");

        try {
            Login login = service.queryLogin(loginName);
            Gson gson = new Gson();
            out.print(gson.toJson(login));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
