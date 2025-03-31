package com.mycom.myapp.calc.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		// Spring DI를 통한 객체 생성
		// main()에서 Spring Framework의 환경
		// 설정 Java Configuration (annotation)
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalcConfiguration.class);
		Calculator calculator = (Calculator)context.getBean("calculator"); //method 이름으로 DI 	
		System.out.println(calculator.add(3, 9));
		context.close();
	}

}
