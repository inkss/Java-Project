package com.inkss.day07_3.mapper;

import com.inkss.day07_3.pojo.OrderDetail;
import com.inkss.day07_3.pojo.OrdersPojo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class OrdersMapperTest {

    private static SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession = sqlSessionFactory.openSession();
    OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

    static {
        String resource = "SqlMapConfig.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectOrdersAndUser() {

        List<OrdersPojo> ordersPojoList = ordersMapper.selectOrdersAndUser();
        for (OrdersPojo ordersPojo : ordersPojoList)
            System.out.println(ordersPojo +" " + ordersPojo.getUser().toString());

    }

    @Test
    public void selectOrdersAndUserAndDetail() {

        List<OrdersPojo> ordersPojoList = ordersMapper.selectOrdersAndUserAndDetail();
        for (OrdersPojo ordersPojo :ordersPojoList) {
            System.out.print(ordersPojo.getUser().toString() + " " +ordersPojo + " " );
            for (OrderDetail orderDetail : ordersPojo.getOrderDetails())
                System.out.print(orderDetail);
            System.out.println();
        }

    }


    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }
}