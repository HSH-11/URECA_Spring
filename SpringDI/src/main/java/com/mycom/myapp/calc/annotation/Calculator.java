package com.mycom.myapp.calc.annotation;

import org.springframework.stereotype.Component;
// 자동으로 Bean에 등록
@Component("abc")
public class Calculator {
	
	public int add(int n1, int n2) {
		return n1 + n2;
	}
}
