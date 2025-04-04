package annotation;

import java.lang.annotation.Annotation;

import workshop.AboutMySelf;


// Spring 입장 MyClass가 사용한 annotation (미리 약속됨)을 파악
// annotation 속성 = 컴파일 시 자동 생성된 구현체에서 값을 돌려주는 메서드
// 자바 컴파일러가 내부적으로 다음과 같은 프록시 클래스를 자동으로 생성해서 처리해준다.
// AboutMe aboutMe = new AboutMe() {
//    public String love() { return "Coding"; }
//    public String hate() { return "Bugs"; }
//
//    public Class<? extends Annotation> annotationType() {
//        return AboutMe.class;
//    }
// };
public class Test2 {
	public static void main(String[] args) throws Exception {
		Class<?> myClass = Class.forName("workshop.MyClassJeongmin");
		
		Annotation[] annotations = myClass.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof AboutMySelf) {
				workshop.AboutMySelf aboutMe = (workshop.AboutMySelf) annotation;
		        System.out.println("Cellphone Maker: " + aboutMe.cellphoneMaker());
		        System.out.println("Is Smoker: " + aboutMe.isSmoker());
			}
		}
		
		// Encrypt
//		User user = new User("홍길동", "1234");
//		System.out.println(user);
//
//		// @Encrypt를 사용한 필드가 있으면 필드값을 암호화 변경
//		Field[] fields = user.getClass().getDeclaredFields();
//
//		for (Field field : fields) {
//			if (field.isAnnotationPresent(Encrypt.class)) {
////				field.setAccessible(true); //private도 가능
////				field.set(user, field.get(user) + "5678");
//				encryptField(user,field);
//				
//			}
//		}
//		
//		System.out.println(user);
//
//	}
//
//	static private void encryptField(Object obj, Field field) {
//		try {
//			field.setAccessible(true);
//			Object value = field.get(obj);
//			if (value instanceof String) {
//				String encrypted = value + "5678"; // 실제로는 암호화 로직 들어가야 함
//				field.set(obj, encrypted);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
}
