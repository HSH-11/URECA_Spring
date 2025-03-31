package com.mycom.myapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// Logging을 담당하는 Aspect
@Component // 객체가 필요한 시점에 Spring이 DI
@Aspect // aspectj 라이브러리에 의해 AOP로 동작 ( <aop:aspectj-autoproxy></aop:aspectj-autoproxy> )
//<aop:aspectj-autoproxy></aop:aspectj-autoproxy>는 Spring에게 Aspect 클래스들을 AOP로 처리해줘!라고 알려주는 설정
//기본 로깅은 slf4j 인터페이스를 사용하고, 그 구현체로 logback이 default이며, 이를 AOP(예: @Aspect)와 함께 쓰면 자동 로그 추적을 할 수 있다
public class LogAspect {

	// Logging 을 위한 객체 필요(aspect와 상관없는 그냥 log를 남기기 위한 객체)
	// trace > debug > info > warn > error 메소드들은 얼마나 더 자세한 혹은 얼마나 더 중요한 로그를 남기느냐 따라 선택
	// Spring Boot의 현재 설정에 따라 로그 출력 결정 default 설정은 info 따라서 info보다 위험한 것들은 출력
	// application.properties에서 설정 가능
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); // LogBack 구현체 (Springbookt default 구현체)
	
	// PointCut ( Join Point ( 모든 메소드 ) 중 어떤 메소드에 끼여 들 것인가 표현): 어디에 AOP 기능을 적용할 지 정의
	// 리턴 패키지 클래스명 파라미터 (com.mycom.myapp.aspect 패키지의 모든 클래스 모든 메소드를 가리킴)
//	@Pointcut(value = "execution(* com.mycom.myapp.aspect.*.*(..))")	
//	@Pointcut(value = "execution(int com.mycom.myapp.aspect.*.*(..))") // int return join point	
//	@Pointcut(value = "execution(* com.mycom.myapp.aspect.*.*(String, int))") // String, int parameter 	
//	@Pointcut(value = "execution(* com.mycom.myapp.aspect.sub.*.*(..))") // sub에만 적용	
	@Pointcut(value = "execution(* com.mycom.myapp.aspect..*.*(..))") // aspect 포함 하위 패키지 모두 대상
	private void logPointcut() {
	} // 이름이 logPointcut()인 Pointcut 1개 생성

	// Advise와 JoinPoint에 의해 실제 로그 구현
	@Before("logPointcut()") // 특정 지점에 도달하기 직전에 실행되는 Advice를 정의
	public void beforeLog(JoinPoint joinPoint) { // JoinPoint 실제 호출되는 메소드
		logger.info("[sysout : before]");
		logger.info(joinPoint.getSignature().getName());

	}

	@After("logPointcut()")
	public void AfterLog(JoinPoint joinPoint) {
		logger.debug("[sysout : after]");

	}

}
