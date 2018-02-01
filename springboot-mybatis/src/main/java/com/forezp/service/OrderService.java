/**
 * 订单服务
 */
package com.forezp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forezp.dao.OrderMapper;
import com.forezp.entity.Order;

@Service
public class OrderService {
	@Autowired
    private OrderMapper orderMapper;
	public List<Order> getOrderList() {
		return orderMapper.findOrderList();
	}
}
