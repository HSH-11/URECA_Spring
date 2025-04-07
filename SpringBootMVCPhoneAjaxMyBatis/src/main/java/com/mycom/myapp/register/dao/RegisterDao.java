package com.mycom.myapp.register.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.register.dto.CustomerDto;

@Mapper
public interface RegisterDao {
    void registerCustomer(CustomerDto customerDto);
}
