package com.mycom.myapp.calc.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		// Spring DI를 통한 객체 생성
		// main()에서 Spring Framework의 환경
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/calc-annotation.xml"); // 설정 xml 문서
//		Calculator calculator = context.getBean(Calculator.class); // Bean 이름을 타입으로 가져오는 방식 (스프링이 이렇게 동작한다)
//		Calculator calculator = (Calculator)context.getBean("calculator"); // class 이름 기준 객체를 DI
		Calculator calculator = (Calculator)context.getBean("abc"); // Bean 이름 지정	
		System.out.println(calculator.add(3, 9));
		context.close();
	}

}
