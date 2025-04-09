package com.mycom.myapp.order.service;

import java.util.List;

import com.mycom.myapp.order.dto.OrderDto;

public interface OrderService {
	boolean makeOrder(OrderDto orderDto);
	List<OrderDto> getOrders(String userid);
}
