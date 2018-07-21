package com.inkss.hb.logInfo.controller;

import com.google.gson.Gson;
import com.inkss.hb.common.ExportExcel;
import com.inkss.hb.common.PojotoGson;
import com.inkss.hb.logInfo.pojo.LogInfo;
import com.inkss.hb.logInfo.service.LogInfoService;
import com.inkss.hb.logInfo.service.LogInfoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "LogInfoController", produces = {"text/html;charset=UTF-8;", "application/json;charset=UTF-8;"})
public class LogInfoController {

    private LogInfoService service = new LogInfoServiceImpl();

    /**
     * 主表格使用
     *
     * @param page  页数
     * @param limit 长度
     * @param make  状态标志
     * @param logId 选中的用户 ID
     * @return 查询内容
     */
    @RequestMapping("logInfoTable.do")
    @ResponseBody
    public Object logInfoTable(String page, String limit, String make, String logId) {

        String code = "0"; //状态码
        String msg = "数据查询正常"; //状态信息
        String count; //数据总数
        List<LogInfo> list; //数据内容

        if (make.equals("4")) { //删除
            //System.out.println("执行删除操作");
            service.deleteLogInfo(Integer.parseInt(logId));
        }

        list = service.query(Integer.parseInt(page), Integer.parseInt(limit));
        count = String.valueOf(service.queryLoginNum());

        PojotoGson pojotoGson = new PojotoGson(code, msg, count, list);
        Gson gson = new Gson();
        return gson.toJson(pojotoGson);
    }

    /**
     * 导出 Excel 表
     *
     * @param response response
     */
    @RequestMapping("toExcel.do")
    @ResponseBody
    public void toExcel(HttpServletResponse response) {

        List<LogInfo> list;

        list = service.query(1, service.queryLoginNum());

        String[] headers = {"日志编号", "内容", "用户编号", "用户名称", "日期"};
        String fileName = "日志信息";

        ExportExcel<LogInfo> ee = new ExportExcel<>();
        ee.exportExcel(headers, list, fileName, response);
    }
}
