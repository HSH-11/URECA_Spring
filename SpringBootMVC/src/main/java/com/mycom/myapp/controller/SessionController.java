package com.mycom.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {

	@GetMapping("/session1")
	public String login(String username, String password, HttpSession session) {
		if ("uplus".equals(username) && "1234".equals(password)) {
			// 서버 공간인 session에 username을 추가
			session.setAttribute("username", username);

		}
		return "sessionTest1";
	}

	@GetMapping("/session2")
	public String m() {
		return "sessionTest2";
	}
}
