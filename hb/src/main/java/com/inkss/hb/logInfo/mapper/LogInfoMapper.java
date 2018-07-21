package com.inkss.hb.logInfo.mapper;

import com.inkss.hb.logInfo.pojo.LogInfo;

import java.util.List;

public interface LogInfoMapper {

    void insertData(LogInfo logInfo);

    void deleteData(Integer loginId);

    int queryDataNum();

    List<LogInfo> queryList(int start, int length);
}
