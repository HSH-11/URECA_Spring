package com.mycom.myapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mycom.myapp.common.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns(
					"/",
					"/index.html",
					"/favicon.ico",
					"/assets/**",
					"/pages/register", // page 요청
					"/pages/user",  // page 요청
					"/pages/login",
					"/auth/**",  // 로그인 ajax 요청
					"/user/**" // 회원가입 ajax 요청
					);
	}
}
