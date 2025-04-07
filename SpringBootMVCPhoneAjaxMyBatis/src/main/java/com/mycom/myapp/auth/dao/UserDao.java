package com.mycom.myapp.auth.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.auth.dto.UserDto;

@Mapper
public interface UserDao {
    UserDto login(UserDto userDto);
}
