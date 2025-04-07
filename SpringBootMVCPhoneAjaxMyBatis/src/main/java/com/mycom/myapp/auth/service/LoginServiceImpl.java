package com.mycom.myapp.auth.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mycom.myapp.auth.dao.AdminDao;
import com.mycom.myapp.auth.dao.UserDao;
import com.mycom.myapp.auth.dto.UserDto;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserDao userDao;
    private final AdminDao adminDao;

    public LoginServiceImpl(UserDao userDao, AdminDao adminDao) {
        this.userDao = userDao;
        this.adminDao = adminDao;
    }

    @Override
    public Optional<UserDto> login(UserDto userDto) {
        String loginType = userDto.getLoginType();

        if ("admin".equals(loginType)) {
            return Optional.ofNullable(adminDao.login(userDto));
        } else {
            return Optional.ofNullable(userDao.login(userDto));
        }
    }
}
