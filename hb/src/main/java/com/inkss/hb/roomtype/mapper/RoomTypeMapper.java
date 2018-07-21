package com.inkss.hb.roomtype.mapper;

import com.inkss.hb.roomtype.pojo.RoomType;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * RoomTypeMapper
 * 提供：
 * 增删改
 * 用户账户密码查询
 * 用户个数查询
 * 用户名查询
 * 用户 ID 查询
 * 范围查询
 */
public interface RoomTypeMapper {

    void insertData(RoomType roomType);

    void deleteData(String typeId);

    void updateData(RoomType login);

    int queryDataNum();

    List<RoomType> queryList(Integer start, Integer length);

    RoomType queryById(String typeId);

    List<RoomType> queryByName(@Param("Name")String typeName);

}
