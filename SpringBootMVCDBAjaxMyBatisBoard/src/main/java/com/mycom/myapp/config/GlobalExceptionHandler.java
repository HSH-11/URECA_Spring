package com.mycom.myapp.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 개별 Controller에서 처리하지 않는 예외 일괄 처리 <= @ControllerAdvice (컨트롤러의 Proxy를 이용)
// 현재 Spring MVC + JSP + Ajax 구조에서는 Ajax 처리 전담
// fetch data 요청에 대해 "result":"exception" 응답

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public Map<String,String> handlerException(Exception e){
			
		Map<String,String> map = new HashMap<>();
		map.put("result", "exception");
		return map;
	}
}
