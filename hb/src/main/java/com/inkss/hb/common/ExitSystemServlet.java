package com.inkss.hb.common;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * 作用 退出系统时 清除session
 */
@WebServlet(value = "/ExitSystemServlet", name = "ExitSystemServlet")
public class ExitSystemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        if (session.getAttribute("LoginName") != null) {
            //System.out.println("已清除---> LoginName的session值\n");
            String loginName = request.getSession().getAttribute("LoginName").toString();
            session.removeAttribute("LoginName");
            /*//写入退出记录
            LoginService service = new LoginServiceImpl();
            Login login = null;
            try {
                login = service.queryLogin(loginName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            LogInfo logInfo = new LogInfo("退出", login.getLoginId(), loginName);
            LogInfoService logInfoService = new LogInfoServiceImpl();
            logInfoService.insertLogInfo(logInfo);*/

        }
    }
}
