package com.mycom.myapp.calc.all;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Calculator 객체 필요
// CalcMain의 Spring Context를 통해서 HasaCalculator 객체를 생성 (DI)
@Component
public class HasaCalculator {

	
	// Spring DI #1 field injection
//		@Autowired //: 스프링이 자동으로 객체를 주입해주는 어노테이션
//		@Qualifier("bbb")
//		Calculator calculator;
		
		// Spring DI #2 setter injection
//		@Autowired
//		@Qualifier("bbb")
//		Calculator calculator;
	//	
//		public void setCalculator(Calculator calculator) {
//			this.calculator = calculator;
//		}
	
	
	// Spring DI #3 constructor injection (Spring 추천방식)
	Calculator calculator; //interface를 implements 한 객체가 DI
	// 단, interface를 implements한 객체가 1개 일때만 가능
	// 만약 2개라면 Component에 이름을 줘야 한다.
	//(Calculator타입의 Bean이 여러개 있어서 Spring이 어떤 걸 넣어야 할 지 몰라서 에러가 나기 때문)
	// 따라서 Qualifier("bean이름")으로 어떤 구현체를 넣을지 명확하게 지정
	
	public HasaCalculator(@Qualifier("bbb")Calculator calculator) {
		super();
		this.calculator = calculator;
	}

	public int add(int n1, int n2) {
		System.out.println("HasaCalculator add()");
		return calculator.add(n1, n2);
	}

}
