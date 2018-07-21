package com.inkss.hb.roomtype.service;

import com.inkss.hb.roomtype.pojo.RoomType;

import java.util.List;

public interface RoomTypeService {

    //增添
    boolean insert(RoomType roomType);

    //删除
    boolean delete(String loginId);

    //更新
    boolean update(RoomType roomType);

    //查询单条
    RoomType queryId(String id);

    //查询多条
    List<RoomType> queryList(int page, int limit);

    List<RoomType> queryByName(String typeName);

    /**
     * 查重函数
     *
     * @param newName oldName 房间类型名称
     * @return 0:已经存在 1：未存在 2：与自身相同
     */
    int queryRepeat(String newName, String oldName);

    //查询长度
    int queryLoginNum();
}
