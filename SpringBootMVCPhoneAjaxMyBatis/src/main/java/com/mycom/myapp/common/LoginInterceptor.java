package com.mycom.myapp.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycom.myapp.auth.dto.UserDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	private final String jsonStr = "{\result\":\"login\"}";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("LoginInterceptor >>>> " + request.getRequestURI());
		
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		
		if (userDto == null) {
			if ("true".equals(request.getHeader("ajax"))) {
				System.out.println("LoginInterceptor >>>> ajax request ");
				response.getWriter().write(jsonStr);
			}
			// page요청
			else {
				System.out.println("LoginInterceptor >>>> page request ");
				response.sendRedirect("/index.html");
			}
			return false;
		}
		
		return true;
	}
}
