package com.mycom.myapp.order.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.auth.dto.UserDto;
import com.mycom.myapp.order.dto.OrderDto;
import com.mycom.myapp.order.service.OrderService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	// 주문 추가
	@PostMapping("/insert")
	public Map<String, String> makeOrder(@RequestBody OrderDto orderDto, HttpSession session) {
        Map<String, String> map = new HashMap<>();
        
        UserDto customer = (UserDto) session.getAttribute("userDto");
        
        if (customer == null) {
        	map.put("result","login");
        	return map;
        }
        
        // 세션의 userid를 OrderDto에 세팅
        orderDto.setUserid(customer.getUserid());

        boolean success = orderService.makeOrder(orderDto);
        map.put("result", success ? "success" : "fail");
        return map;
    }
	
}
