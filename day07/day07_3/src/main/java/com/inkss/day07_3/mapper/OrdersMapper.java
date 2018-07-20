package com.inkss.day07_3.mapper;

import com.inkss.day07_3.pojo.OrdersPojo;

import java.util.List;

public interface OrdersMapper {

    // 一对一查询
    List<OrdersPojo> selectOrdersAndUser();

    // 一对多查询
    List<OrdersPojo> selectOrdersAndUserAndDetail();

    List<OrdersPojo> selectAll();
}
