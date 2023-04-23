package IntroductionSynchronization;

public class MyClass extends Thread  {
	private String name;
	private MyObject myObj;
	
	public MyClass(MyObject obj, String n) {
		name = n;
		myObj = obj;
	}
	
	public void run() {
		if (name.equals("1")) {
			MyObject.foo(name);
		} else if (name.equals("2")) {
			MyObject.bar(name);
		}
	}
}
