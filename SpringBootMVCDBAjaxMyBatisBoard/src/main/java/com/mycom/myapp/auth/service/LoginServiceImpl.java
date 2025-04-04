package com.mycom.myapp.auth.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mycom.myapp.auth.dao.LoginDao;
import com.mycom.myapp.user.dto.UserDto;

@Service
public class LoginServiceImpl implements LoginService{
	private final LoginDao loginDao;
	
	public LoginServiceImpl(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	// null을 return할 수 있는 메소드는 호출하는 쪽에 그것을 알리는 방법 Optional을 사용.
	@Override
	public Optional<UserDto> login(UserDto userDto) {
		UserDto dto = loginDao.login(userDto.getUserEmail());
		if (dto != null && userDto.getUserPassword().equals(dto.getUserPassword())) {
			return Optional.of(dto);
		}
		return Optional.empty();
	}
	
	
	
}
