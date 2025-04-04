package proxy;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		MyIF myIF = new MyIFImpl();
		
		String param1 = "abc";
		String param2 = "def"; // null로 바꿀 시 CheckNotNull 어노테이션 붙은 메서드 에러
		
		// proxy 없이 객체의 메소드를 직접 호출
		myIF.m(param1, param2);
		myIF.m2(param1, param2);
		myIF.m3(param1, param2);
		myIF.m4(param1, param2);
		
		// myIF 객체의 proxy를 이용해서 점검하고 호출
		// 같은 type으로
		// InvocationHandler : 객체의 메소드가 호출될 때 대신 점검하고 호출 역할
		// 모든 proxy 객체는 반드시 InvocationHandler 객체를 가져야 한다.
		
		MyIF proxy = (MyIF) Proxy.newProxyInstance(
				myIF.getClass().getClassLoader(), 
				myIF.getClass().getInterfaces(), 
				new CheckNotNullInvocationHandler(myIF));
		// 3번째가 가장 중요
		
		// proxy 객체를 사용
		proxy.m(param1, param2);
		proxy.m2(param1, param2);
		proxy.m3(param1, param2);
		proxy.m4(param1, param2);
	}
}
