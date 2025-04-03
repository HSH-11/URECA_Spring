package com.mycom.myapp.controller;

import com.mycom.myapp.dto.CustomerDto;
import com.mycom.myapp.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<CustomerDto> list() {
		List<CustomerDto> CustomerList = customerService.getAllCustomers();
		return CustomerList;
	}

	@PostMapping(value = "/insert")
	@ResponseBody
	public Map<String, String> insert(@RequestParam String name,
	                                  @RequestParam String email,
	                                  @RequestParam String phone,
	                                  @RequestParam String address) {

	    CustomerDto customer = new CustomerDto();
	    customer.setName(name);
	    customer.setEmail(email);
	    customer.setPhone(phone);
	    customer.setAddress(address);

	    customerService.insertCustomer(customer);

	    Map<String, String> result = new HashMap<>();
	    result.put("result", "success");
	    return result;
	}

	@PostMapping(value = "/update")
	@ResponseBody
	public void updateCustomer(CustomerDto customerDto) {
		System.out.println(customerDto); 
		customerService.updateCustomer(customerDto);
	}

	@GetMapping(value = "/delete/{customerId}")
	@ResponseBody
	public void deleteCustomer(@PathVariable int customerId) {
		System.out.println("삭제 요청 customerId: " + customerId);
		customerService.deleteCustomer(customerId);
	}
}
