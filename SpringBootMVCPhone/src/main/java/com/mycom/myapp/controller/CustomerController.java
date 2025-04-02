package com.mycom.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.dto.CustomerDTO;
import com.mycom.myapp.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	// customers.jsp로 이동
	@GetMapping(value = "/")
	public String customerMain() {
		return "customers";
	}

	@GetMapping(value = "/list")
	@ResponseBody
	public List<CustomerDTO> listBook() {
		List<CustomerDTO> CustomerList = customerService.getAllCustomers();
		return CustomerList;
	}

	@PostMapping(value = "/insert")
	@ResponseBody
	public void insert(@RequestParam String name, @RequestParam String email, @RequestParam String phone,
			@RequestParam String address) {
		customerService.findOrCreateCustomer(name, email, phone, address);

	}

	@PostMapping(value = "/update")
	@ResponseBody
	public void updateCustomer(CustomerDTO customerDto) {
		System.out.println(customerDto); // 디버깅 출력
		customerService.updateCustomer(customerDto);
	}

	@GetMapping(value = "/delete/{customerId}")
	@ResponseBody
	public void deleteCustomer(@PathVariable int customerId) {
		System.out.println("삭제 요청 customerId: " + customerId);
		customerService.deleteCustomer(customerId);
	}
}
