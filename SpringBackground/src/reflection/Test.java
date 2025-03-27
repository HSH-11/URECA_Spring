package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Spring Framework가 User를 들여다 본다
// reflection api
public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Class<?> userClass = Class.forName("reflection.User");

		// class 이름
		System.out.println(userClass.getName());

		// field
		Field[] fields = userClass.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
			System.out.println(field.getType());
			System.out.println();
		}

		// method
		Method[] methods = userClass.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
			System.out.println(method.getReturnType());
			System.out.println();
		}
		
		// Constructor
		Constructor<?>[] constructors = userClass.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor.getName());
			System.out.println(constructor.getParameterCount());
			System.out.println(constructor);
		}

	}

}
