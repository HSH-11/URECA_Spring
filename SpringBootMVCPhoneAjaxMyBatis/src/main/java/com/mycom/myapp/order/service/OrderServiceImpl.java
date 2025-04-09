package com.mycom.myapp.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.order.dao.OrderDao;
import com.mycom.myapp.order.dto.OrderDto;

@Service
public class OrderServiceImpl implements OrderService{
	private final OrderDao orderDao;

	public OrderServiceImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public boolean makeOrder(OrderDto orderDto) {
		try {
			orderDao.insertOrder(orderDto);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<OrderDto> getOrders(String userid) {
		return orderDao.getOrderByCustomerId(userid);
	}
	
	
}
