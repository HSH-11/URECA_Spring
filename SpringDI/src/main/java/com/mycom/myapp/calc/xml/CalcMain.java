package com.mycom.myapp.calc.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		// 개발자가 직접 객체 생성
//		Calculator calculator = new Calculator(); // 생성된 객체 의존성
//		System.out.println(calculator.add(3,7));
//		
		// Spring DI를 통한 객체 생성
		// main()에서 Spring Framework의 환경
		// 특별한 경로 안주면 src/main/resources를 가리킨다.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/calc-xml.xml"); // 설정 xml 문서
		Calculator calculator = context.getBean(Calculator.class); // Bean 이름을 타입으로 가져오는 방식 (스프링이 이렇게 동작한다)
//		Calculator calculator = (Calculator)context.getBean("calculator"); // id 기준 객체를 DI
		System.out.println(calculator.add(3, 7));
		context.close();
	}

}
