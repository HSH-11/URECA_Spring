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

		// 로그인 타입에 따라 분기 처리
		if ("admin".equals(loginType)) {
			UserDto adminDto = adminDao.login(userDto);
			if (adminDto != null) {
				adminDto.setLoginType("admin"); // 로그인 성공 시 관리자 타입 설정
				return Optional.of(adminDto);
			}
		} else {
			UserDto user = userDao.login(userDto);
			if (user != null) {
				user.setLoginType("user"); // 로그인 성공 시 일반 사용자 타입 설정
				return Optional.of(user);
			}
		}

		// 로그인 실패 시
		return Optional.empty();
	}
}
