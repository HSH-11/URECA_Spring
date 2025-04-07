package com.mycom.myapp.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

// jsp 페이지 이동 담당
@Controller
public class PageController {
	
	@GetMapping("/pages/register")
	public String register() {
		return "register";
	}
	@GetMapping("/pages/board")
	public String board() {
		return "board";
	}

	@GetMapping("/pages/login")
	public String login() {
		return "login";
	}
	
	
	@GetMapping("/pages/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
