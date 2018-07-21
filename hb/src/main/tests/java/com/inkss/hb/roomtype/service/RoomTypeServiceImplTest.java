package com.inkss.hb.roomtype.service;

import com.inkss.hb.roomtype.pojo.RoomType;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RoomTypeServiceImplTest {

    private RoomTypeService service = new RoomTypeServiceImpl();

    @Test
    public void insert() {
        RoomType roomType = new RoomType("测试2","1","1",1,"1");
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
        roomType.setTypeId("RT" + df.format(day));
        service.insert(roomType);
    }

    @Test
    public void delete() {
        service.delete("RT180721142941");
    }

    @Test
    public void update() {
    }

    @Test
    public void queryId() {
        System.out.println(service.queryId("RT180721140923"));
    }

    @Test
    public void queryList() {
        List<RoomType> list = service.queryList(1,2);
        System.out.println(list);

    }

    @Test
    public void queryRepeat() {
    }

    @Test
    public void queryLoginNum() {
    }
}