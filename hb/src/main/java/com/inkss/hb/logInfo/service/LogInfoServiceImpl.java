package com.inkss.hb.logInfo.service;

import com.inkss.hb.logInfo.mapper.LogInfoMapper;
import com.inkss.hb.logInfo.pojo.LogInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LogInfoServiceImpl implements LogInfoService {

    private static SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession = null;
    private LogInfoMapper logInfoMapper = null;

    static {
        String resource = "SqlMapConfig.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean insertLogInfo(LogInfo logInfo) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            logInfoMapper  = sqlSession.getMapper(LogInfoMapper.class);
            logInfoMapper.insertData(logInfo);
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean deleteLogInfo(int logId) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            logInfoMapper  = sqlSession.getMapper(LogInfoMapper.class);
            logInfoMapper.deleteData(logId);
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public int queryLoginNum() {
        sqlSession = sqlSessionFactory.openSession();
        logInfoMapper = sqlSession.getMapper(LogInfoMapper.class);
        int num = logInfoMapper.queryDataNum();
        sqlSession.close();
        return num;
    }

    @Override
    public List<LogInfo> query(int page, int limit) {

        int start = (page * limit) - limit; //每一页的起始位置
        if (start < 0)  //小于0的话会触发一个错误
            start = 0;  //但是理论上page和limit是由table表格生成的参数

        try {
            sqlSession = sqlSessionFactory.openSession();
            logInfoMapper = sqlSession.getMapper(LogInfoMapper.class);
            return logInfoMapper.queryList(start, limit);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            sqlSession.close();
        }
    }
}
