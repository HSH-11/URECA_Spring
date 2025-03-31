package com.mycom.myapp.calc.all;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		// Spring DI를 통한 객체 생성
		// main()에서 Spring Framework의 환경
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/all-calc-annotation.xml"); // 설정 xml 문서
		HasaCalculator hasacalculator = (HasaCalculator)context.getBean("hasaCalculator"); // Bean 이름 지정	
		System.out.println(hasacalculator.add(3, 7));
		context.close();
	}

}
