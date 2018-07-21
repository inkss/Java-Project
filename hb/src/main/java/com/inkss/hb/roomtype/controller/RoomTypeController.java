package com.inkss.hb.roomtype.controller;

import com.google.gson.Gson;
import com.inkss.hb.common.ExportExcel;
import com.inkss.hb.common.PojotoGson;
import com.inkss.hb.roomtype.pojo.RoomType;
import com.inkss.hb.roomtype.service.RoomTypeService;
import com.inkss.hb.roomtype.service.RoomTypeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.List;

@Controller
@RequestMapping(value = "RoomTypeController", produces = {"text/html;charset=UTF-8;", "application/json;charset=UTF-8;"})
public class RoomTypeController {

    private RoomTypeService service = new RoomTypeServiceImpl();

    /**
     * 主表格使用
     *
     * @param page     页数
     * @param limit    长度
     * @param make     状态标志
     * @param logId    选中的用户 ID
     * @param typeName 选中的用户 typeName
     * @return 查询内容
     */
    @RequestMapping("roomTypeTable.do")
    @ResponseBody
    public Object RoomTypeTable(String page, String limit, String make, String typeId, String typeName
            , String price, String splicPrice, String exceedance, String isSplice) {

        String code = "0"; //状态码
        String msg = "数据查询正常"; //状态信息
        String count; //数据总数
        List<RoomType> list; //数据内容

        list = service.queryList(Integer.parseInt(page), Integer.parseInt(limit));
        count = String.valueOf(service.queryLoginNum());

        if (make.equals("4")) { //删除
            service.delete(typeId);
            list = service.queryList(Integer.parseInt(page), Integer.parseInt(limit));
            count = String.valueOf(service.queryLoginNum());
        } else if (make.equals("3")) { //搜索
            list = service.queryByName(typeName);
            count = String.valueOf(list.size());
        } else if (make.equals("2")) {
            RoomType roomType = new RoomType(typeId, typeName, price, splicPrice
                    , Integer.parseInt(exceedance), isSplice);
            service.update(roomType);
        }

        PojotoGson pojotoGson = new PojotoGson(code, msg, count, list);
        Gson gson = new Gson();
        return gson.toJson(pojotoGson);
    }

    /**
     * 0:已经存在 1：未存在 2：与自身相同
     *
     * @param newName 新
     * @param oldName 旧
     * @return 0 1 2
     */
    @RequestMapping("queryRepeat.do")
    @ResponseBody
    public String queryRepeat(String newName, String oldName) {

        String check = String.valueOf(service.queryRepeat(newName,oldName));
        return check;
    }

    /**
     * 导出 Excel 表
     *
     * @param response response
     */
    @RequestMapping("toExcel.do")
    @ResponseBody
    public void toExcel(HttpServletResponse response) {

        List<RoomType> list;

        list = service.queryList(1, service.queryLoginNum());

        String[] headers = {"类型编号", "类型名称", "价格", "拼房价格", "可超预定数", "是否可拼房"};
        String fileName = "房间类型信息";

        ExportExcel<RoomType> ee = new ExportExcel<>();
        ee.exportExcel(headers, list, fileName, response);
    }

    /**
     * 新增
     *
     * @param request request
     * @return 重复 1 、成功 OK 、失败 0
     */
    @RequestMapping("insertRoomType.do")
    @ResponseBody
    public String insertRoomType(HttpServletRequest request) {

        try {
            BufferedReader reader = request.getReader(); // 获取前端传递的json数据
            String json = reader.readLine();
            Gson gson = new Gson(); // 解析json
            RoomType roomType = gson.fromJson(json, RoomType.class);
            if (service.queryRepeat(roomType.getTypeName(), roomType.getTypeName()) == 0)
                return "1"; // 已经存在的用户
            service.insert(roomType);
            return "ok";
        } catch (Exception e) {
            return "0";
        }
    }
}
