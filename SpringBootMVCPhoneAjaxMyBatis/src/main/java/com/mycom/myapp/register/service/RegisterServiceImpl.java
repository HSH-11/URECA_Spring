package com.mycom.myapp.register.service;

import com.mycom.myapp.register.dao.RegisterDao;
import com.mycom.myapp.register.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final RegisterDao registerDao;

    public RegisterServiceImpl(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }

    @Override
    public boolean registerCustomer(CustomerDto customerDto) {
        try {
            registerDao.registerCustomer(customerDto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
