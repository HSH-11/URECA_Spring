package com.mycom.myapp.calc.hasa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Calculator 객체 필요
// CalcMain의 Spring Context를 통해서 HasaCalculator 객체를 생성 (DI)
@Component
public class HasaCalculator {
	// Spring DI를 사용하지 않는 경우
//	Calculator calculator = new Calculator();
	
	// Spring DI #1 field injection
//	@Autowired: 스프링이 자동으로 객체를 주입해주는 어노테이션
//	Calculator calculator;
	
	// Spring DI #2 setter injection
//	@Autowired
//	Calculator calculator;
//	
//	public void setCalculator(Calculator calculator) {
//		this.calculator = calculator;
//	}
	
	// Spring DI #3 constructor injection
	// 생성자 injection에 대해서는 @Autowired 필요 X
	Calculator calculator;
	

	public HasaCalculator(Calculator calculator) {
		super();
		this.calculator = calculator;
	}


	public int add(int n1, int n2) {
		System.out.println("HasaCalculator add()");
		return calculator.add(n1, n2);
	}
	
}
