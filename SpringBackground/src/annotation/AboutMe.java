package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// interface 앞에 @ 붙여서 annotation 생성
// 어디에 사용할 것인가? TYPE,METHOD
@Retention(RetentionPolicy.RUNTIME) // 언제까지 어노테이션이 살아있을지 정함, RUNTIME이면 실행 중에 반영되고 리플랙션으로 읽을 수 있다.
@Target(ElementType.TYPE) // 어노테이션을 클래스,인터페이스.enum 등에 붙일 수 있다는 뜻
public @interface AboutMe {
	// 추상 메소드로 annotation의 attribute 생성
	String love();
	String hate();
}

// @AboutMe
