package com.mycom.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.dao.CustomerDao;
import com.mycom.myapp.dto.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {

		return customerDao.getAllCustomers();
	}

	@Override
	public boolean deleteCustomer(int customerId) {

		return customerDao.deleteCustomer(customerId);
	}

	@Override
	public boolean updateCustomer(CustomerDTO customer) {

		return customerDao.updateCustomer(customer);
	}

	@Override
	public CustomerDTO findCustomer(String name, String phone) {

		return customerDao.findCustomer(name, phone);
	}

	@Override
	public CustomerDTO findOrCreateCustomer(String name, String email, String phone, String address) {

		return customerDao.findOrCreateCustomer(name, email, phone, address);
	}

}
