package com.mycom.myapp.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Spring을 통해서 WAS에 filter 등록
// @Component + implements Filter
// /xyx의 요청은 거부 403 Forbidden 응답 코드
@Component
public class MyFilter2 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFilter2 >>> Before Filter Job");
		// 요청 url check
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		if (httpRequest.getRequestURI().contains("/xyz")) {
			httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN,"접근 금지된 url 입니다.");
			return; /// doFilter() X
		}
		
		chain.doFilter(request, response);
		
		System.out.println("MyFilter2 >>> After Filter Job");
		
	}
	
}
