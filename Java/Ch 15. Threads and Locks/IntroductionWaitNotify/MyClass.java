package IntroductionWaitNotify;

public class MyClass extends Thread  {
	private String name;
	private MyObject myObj;
	
	public MyClass(MyObject obj, String n) {
		name = n;
		myObj = obj;
	}
	
	public void run() {
		try {
			myObj.wait(1000);
			myObj.foo(name);
			myObj.notify();			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
