package com.mycom.myapp.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.order.dto.OrderDto;

@Mapper
public interface OrderDao {
	void insertOrder(OrderDto orderDto);
	List<OrderDto> getOrderByCustomerId(String userid); // 사용자 주문 조회용
	
}
