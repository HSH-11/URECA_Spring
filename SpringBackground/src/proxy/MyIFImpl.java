package proxy;

public class MyIFImpl implements MyIF{
	
	@Override
	public void m (String param1, String param2) {
		System.out.println("m()");
		System.out.println(param1 + ", " + param2);
	}
	@Override
	@CheckNotNull(parameterNames= {"param1","param2"})
	public void m2 (String param1, String param2) {
		System.out.println("m2()");
		System.out.println(param1 + ", " + param2);
	}
	@Override
	public void m3 (String param1, String param2) {
		System.out.println("m3()");
		System.out.println(param1 + ", " + param2);
	}
	@Override
	public void m4 (String param1, String param2) {
		System.out.println("m4()");
		System.out.println(param1 + ", " + param2);
	}
}
