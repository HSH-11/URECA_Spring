package com.mycom.myapp.service;

import java.util.List;

import com.mycom.myapp.dto.CustomerDto;

public interface CustomerService {
	List<CustomerDto> getAllCustomers();

	boolean updateCustomer(CustomerDto customer);

	boolean deleteCustomer(int customerId);

	boolean insertCustomer(CustomerDto customer);
}
