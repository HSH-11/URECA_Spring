package com.mycom.myapp.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// DI 용도가 아니라, Spring에게 Interceptor 정책 전달

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	// Filter와 달리 Interceptor는 view로 forwarding하는 과정에서도 도장
	// abc: DispatcherServlet 다음으로 Contorller 접근 과정에서 한번 실행, 다시 DispatcherServlet
	// abc/abc.html: DispatcherServlet이 다시 처리하는 과정에서 한번 더 동작

	// #1
//	@Autowired
//	private MyInterceptor myInterceptor;
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(myInterceptor).addPathPatterns("/**")
//		.excludePathPatterns("/login/**"); // interceptor를 적용하지 않을 대상

	// #2
	@Autowired
	private MyInterceptor2 myInterceptor2;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myInterceptor2)
			.addPathPatterns("/**")
			.excludePathPatterns("/login/**"); 
																										// 적용하지 않을 대상
	}

}
