package com.mycom.myapp.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
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
		
		// 예외처리 테스트
//		String s = null;
//		s.length();
//		
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
//	@GetMapping("/pages/json")
//	@ResponseBody
//	public LocalDateTime json() {
//		return LocalDateTime.now();
//	}
	
	// 현재 Controller 작업 수행 시 예외 발생 => 예외처리 jsp 이동
	// try-catch의 catch() 역할
//	@ExceptionHandler(Exception.class)
//	public String pageExctionHandler(Exception ex, Model model, HttpServletRequest request) {
//		model.addAttribute("exception",ex);
//		model.addAttribute("requestURI",request.getRequestURI());
//		return "error"; //error.jsp
//	}
}
