package com.inkss.hb.logInfo.service;

import com.inkss.hb.logInfo.pojo.LogInfo;

import java.util.List;

public interface LogInfoService {

    //增添
    boolean insertLogInfo(LogInfo logInfo);

    //删除
    boolean deleteLogInfo(int logId);

    //查询长度
    int queryLoginNum();

    //查询多条
    List<LogInfo> query(int page, int limit);
}
