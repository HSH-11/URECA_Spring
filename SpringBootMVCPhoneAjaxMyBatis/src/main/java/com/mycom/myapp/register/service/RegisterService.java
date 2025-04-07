package com.mycom.myapp.register.service;

import com.mycom.myapp.register.dto.CustomerDto;

public interface RegisterService {
    boolean registerCustomer(CustomerDto customerDto);
}
