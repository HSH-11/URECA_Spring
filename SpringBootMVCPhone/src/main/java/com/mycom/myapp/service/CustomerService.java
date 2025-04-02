package com.mycom.myapp.service;

import java.util.List;

import com.mycom.myapp.dto.CustomerDTO;

public interface CustomerService {
	List<CustomerDTO> getAllCustomers();

	boolean deleteCustomer(int customerId);

	boolean updateCustomer(CustomerDTO customer);

	CustomerDTO findCustomer(String name, String phone);

	CustomerDTO findOrCreateCustomer(String name, String email, String phone, String address);
}
