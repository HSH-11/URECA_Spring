package com.mycom.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.dao.CustomerDao;
import com.mycom.myapp.dto.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public boolean insertCustomer(CustomerDto customer) {
        return customerDao.insertCustomer(customer) == 1;
    }

    @Override
    public boolean updateCustomer(CustomerDto customer) {
        return customerDao.updateCustomer(customer) == 1;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        return customerDao.deleteCustomer(customerId) == 1;
    }
}

