package com.mycom.myapp.auth.service;

import java.util.Optional;

import com.mycom.myapp.auth.dto.UserDto;

// LoginResultDto를 만들지 않고 UserDto를 return하는 이유는 controller에서 session 처리를 하고 난 뒤에 front에 응답
public interface LoginService {
	Optional<UserDto> login(UserDto userDto);
}
