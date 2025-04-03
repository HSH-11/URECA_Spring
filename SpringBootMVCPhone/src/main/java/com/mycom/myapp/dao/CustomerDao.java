package com.mycom.myapp.dao;

import java.util.List;

import com.mycom.myapp.dto.CustomerDTO;


@Mapper
public interface CustomerDao {
	List<CustomerDTO> getAllCustomers();

	boolean deleteCustomer(int customerId);

	boolean updateCustomer(CustomerDTO customer);

	CustomerDTO findCustomer(String name, String phone);

	CustomerDTO findOrCreateCustomer(String name, String email, String phone, String address);

}
