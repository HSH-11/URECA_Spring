package com.mycom.myapp.common;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	// jackson, gson 두 library의 LocalDateTime 객체의 json문자열 비교
	// jackson : "2025-04-08T11:16:25.3202645"
	// gson : {"date":{"year":2025,"month":4,"day":8},"time":{"hour":11,"minute":29,"second":7,"nano":847688800}}
	@GetMapping("/pages/json")
	@ResponseBody
	public LocalDateTime json() {
		return LocalDateTime.now();
	}
}
