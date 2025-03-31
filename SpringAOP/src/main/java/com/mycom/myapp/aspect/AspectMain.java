package com.mycom.myapp.aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycom.myapp.aspect.sub.SubBusinessProcess;


//AOP는 반복되는 코드(공통 관심사)를 한 곳에 모아서, 핵심 비즈니스 로직을 깔끔하게 유지하게 해줍니다.
public class AspectMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/aspect.xml");
		BusinessProcess bp = (BusinessProcess) context.getBean("businessProcess");
		bp.bp();
		System.out.println("--------------------------------------------------");
		
		bp.no_bp();
		System.out.println("--------------------------------------------------");
		
		bp.int_bp();
		System.out.println("--------------------------------------------------");
		
		bp.int_String_bp("s1",0);
		System.out.println("--------------------------------------------------");
		
		SubBusinessProcess sbp = (SubBusinessProcess) context.getBean("subBusinessProcess");
		sbp.bp();
		System.out.println("--------------------------------------------------");
		
		
		context.close();
	}

}
