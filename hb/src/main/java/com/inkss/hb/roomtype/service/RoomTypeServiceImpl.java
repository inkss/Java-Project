package com.inkss.hb.roomtype.service;

import com.inkss.hb.roomtype.mapper.RoomTypeMapper;
import com.inkss.hb.roomtype.pojo.RoomType;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RoomTypeServiceImpl implements RoomTypeService {

    private static SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession = null;
    private RoomTypeMapper mapper = null;

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
    public boolean insert(RoomType roomType) {

        try {
            String name = roomType.getTypeName();
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(RoomTypeMapper.class);
            if (queryRepeat(name, name) != 1) {
                return false;
            }
            Date day = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
            roomType.setTypeId("RT" + df.format(day));
            mapper.insertData(roomType);
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
    public boolean delete(String loginId) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(RoomTypeMapper.class);
            mapper.deleteData(loginId);
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
    public boolean update(RoomType roomType) {
        try {
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(RoomTypeMapper.class);
            String name = roomType.getTypeName();
            if (queryRepeat(name, name) != 1) {
                return false;
            }
            mapper.updateData(roomType);
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
    public RoomType queryId(String id) {

        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(RoomTypeMapper.class);

        RoomType roomType = mapper.queryById(id);
        sqlSession.close();
        return roomType;
    }

    @Override
    public List<RoomType> queryList(int page, int limit) {
        int start = (page * limit) - limit; //每一页的起始位置
        if (start < 0)  //小于0的话会触发一个错误
            start = 0;  //但是理论上page和limit是由table表格生成的参数

        try {
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(RoomTypeMapper.class);
            return mapper.queryList(start, limit);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<RoomType> queryByName(String typeName) {

        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(RoomTypeMapper.class);

        List<RoomType> roomTypes = mapper.queryByName(typeName);
        sqlSession.close();
        return roomTypes;
    }

    @Override
    public int queryRepeat(String newName, String oldName) {
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(RoomTypeMapper.class);

        try {
            RoomType roomType = null;
            List<RoomType> list = mapper.queryByName(newName);
            for (RoomType roomType1 : list) {
                roomType = roomType1;
            }
            if (roomType == null)
                return 1;
            if (!roomType.isNull()) {//表示存在同名项
                if (roomType.getTypeName().equals(oldName))
                    return 2;           //表示存在同名项，但是是与传递来的相同
                return 0;
            } else
                return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int queryLoginNum() {
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(RoomTypeMapper.class);
        int num = mapper.queryDataNum();
        sqlSession.close();
        return num;
    }
}
