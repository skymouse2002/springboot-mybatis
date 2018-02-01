package com.forezp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import com.forezp.entity.Order;
@Mapper
public interface OrderMapper {

    @Select("select id, name as name, money as money from order")
    List<Order> findOrderList();
}
