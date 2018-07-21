package com.inkss.hb.login.controller;

import com.google.gson.Gson;
import com.inkss.hb.common.ExportExcel;
import com.inkss.hb.common.PojotoGson;
import com.inkss.hb.logInfo.pojo.LogInfo;
import com.inkss.hb.logInfo.service.LogInfoService;
import com.inkss.hb.logInfo.service.LogInfoServiceImpl;
import com.inkss.hb.login.pojo.Login;
import com.inkss.hb.login.service.LoginService;
import com.inkss.hb.login.service.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.util.List;

@Controller
@RequestMapping(value = "LoginController", produces = {"text/html;charset=UTF-8;", "application/json;charset=UTF-8;"})
public class LoginController {

    private LoginService service = new LoginServiceImpl();

    /**
     * 主 Login 表格使用
     *
     * @param page    页数
     * @param limit   长度
     * @param make    状态标志
     * @param loginId 选中的用户 ID
     * @return 查询内容
     */
    @RequestMapping("loginTable.do")
    @ResponseBody
    public Object loginTable(String page, String limit, String make, String loginId) {

        String code = "0"; //状态码
        String msg = "数据查询正常"; //状态信息
        String count; //数据总数
        List<Login> list; //数据内容

        if (make.equals("4")) { //删除
            //System.out.println("执行删除操作");
            service.deleteLogin(Integer.parseInt(loginId));
        }

        list = service.query(Integer.parseInt(page), Integer.parseInt(limit));
        count = String.valueOf(service.queryLoginNum());

        PojotoGson pojotoGson = new PojotoGson(code, msg, count, list);
        Gson gson = new Gson();
        return gson.toJson(pojotoGson);
    }

    /**
     * 修改用户密码
     *
     * @param loginName 用户名
     * @param loginPwd  用户密码
     * @return 0/1
     */
    @RequestMapping("updatePwd.do")
    @ResponseBody
    public String updatePwd(String loginName, String loginPwd) {

        String data = "0";
        try {
            Login login = service.queryLogin(loginName); // 查询
            login.setLoginPwd(loginPwd); // 更改
            service.updateLogin(login); // 更新
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }

    /**
     * 导出 Excel 表
     *
     * @param response response
     */
    @RequestMapping("toExcel.do")
    @ResponseBody
    public void toExcel(HttpServletResponse response) {

        List<Login> loginList;

        loginList = service.query(1, service.queryLoginNum());

        String[] headers = {"用户ID", "用户登录名", "用户密码", "用户昵称", "用户权限"};
        String fileName = "用户信息";

        ExportExcel<Login> ee = new ExportExcel<>();
        ee.exportExcel(headers, loginList, fileName, response);
    }

    /**
     * 新增用户
     *
     * @param request request
     * @return 重复 1 、成功 OK 、失败 0
     */
    @RequestMapping("insertLogin.do")
    @ResponseBody
    public String insertLogin(HttpServletRequest request) {

        try {

            BufferedReader reader = request.getReader(); // 获取前端传递的json数据
            String json = reader.readLine();
            Gson gson = new Gson(); // 解析json
            Login login = gson.fromJson(json, Login.class);
            if (service.queryLogin(login.getLoginName()) != null)
                return "1"; // 已经存在的用户
            service.insertLogin(login);
            System.out.println(login);
            return "ok";
        } catch (Exception e) {
            return "0";
        }

    }

    /**
     * 登录成功与否的判断
     *
     * @param loginName 用户名
     * @param loginPwd  密码
     * @param session   session
     * @return 整型 1 -1 0
     */
    @RequestMapping("login.do")
    @ResponseBody
    public String toLogin(String loginName, String loginPwd, HttpSession session) {

        String data = String.valueOf(service.queryByName(loginName, loginPwd));

        if (data.equals("1")) {
            Login login = service.queryLogin(loginName);
            session.setAttribute("loginName", loginName);
            session.setAttribute("loginId", login.getLoginId());
            session.setAttribute("loginNickName", login.getLoginNickName());
            session.setAttribute("loginAdmin", login.getLoginAdmin());

            //写入登录记录
            LogInfo logInfo = new LogInfo("登录", login.getLoginId(), login.getLoginName());
            LogInfoService logInfoService = new LogInfoServiceImpl();
            logInfoService.insertLogInfo(logInfo);
        }
        Gson gson = new Gson();

        return gson.toJson(data);
    }

    /**
     * 退出系统清空 session
     *
     * @param session session
     * @return ""
     */
    @RequestMapping("exitSystem.do")
    @ResponseBody
    public String toList(HttpSession session) {
        int loginId = (int) session.getAttribute("loginId");
        String loginName = (String) session.getAttribute("loginName");

        //写入退出记录
        LogInfo logInfo = new LogInfo("退出", loginId, loginName);
        LogInfoService logInfoService = new LogInfoServiceImpl();
        logInfoService.insertLogInfo(logInfo);
        session.removeAttribute("loginId");
        session.removeAttribute("loginName");
        session.removeAttribute("loginNickPwd");
        session.removeAttribute("loginAdmin");
        session.invalidate();

        return "";
    }


}
