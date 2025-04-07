package com.mycom.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@GetMapping("/abc")
	public String abc() {
		System.out.println("/abc");
		return "/abc/abc.html";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("/login");
		return "/login/login.html";
	}
	
	@GetMapping("/login/success")
	public String loginSuccess(HttpSession session) {
		System.out.println("/loginSuccess");
		session.setAttribute("login", "success");
		return "/login/loginSuccess.html";
	}
}
