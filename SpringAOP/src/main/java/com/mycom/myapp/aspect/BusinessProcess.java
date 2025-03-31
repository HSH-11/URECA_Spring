package com.mycom.myapp.aspect;

import org.springframework.stereotype.Component;

// 개발자가 집중 개발하는 비즈지스 로직을 구현하는 클래스
// LogAspect가 Logging을 위해 비즈니스 로직에 끼어들어서 수행

@Component
public class BusinessProcess {
	
	public void bp() {
		System.out.println("BusineessProcess : bp() !!");
	}
	
	public void no_bp() {
		System.out.println("BusineessProcess : no_bp() !!");
	}
	
	public int int_bp() {
		System.out.println("BusinessProcess : int_bp() !!");
		return 0;
	}
	
	public int int_String_bp(String s1, int n) {
		System.out.println("BusinessProcess : int_String_bp() !!");
		return 0;
	}
}
