package com.mycom.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.dto.CustomerDto;

@Mapper
public interface CustomerDao {
	List<CustomerDto> getAllCustomers();

	int insertCustomer(CustomerDto customer);

	int deleteCustomer(int customerId);

	int updateCustomer(CustomerDto customer);
}
