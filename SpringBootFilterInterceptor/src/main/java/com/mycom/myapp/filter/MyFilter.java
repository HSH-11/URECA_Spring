package com.mycom.myapp.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

// Spring을 통해서 WAS에 filter 등록
// @Component + implements Filter
@Component
public class MyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFilter >>> Before Filter Job");
		// filter 처리 ( controller 이전 작업)
		// 작업 결과에 따라 통과, 거철 처리
		// 현재 이 filter는 무조건 통과
		
		chain.doFilter(request, response);
		
		System.out.println("MyFilter >>> After Filter Job");
		
	}
	
}
