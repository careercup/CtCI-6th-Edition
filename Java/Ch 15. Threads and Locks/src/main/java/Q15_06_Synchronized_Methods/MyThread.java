package Q15_06_Synchronized_Methods;

public class MyThread extends Thread {
	private Foo foo;
	public String name;
	public String firstMethod;
	public MyThread(Foo f, String nm, String fM) {
		foo = f;
		name = nm;
		firstMethod = fM;
	}
	
	public void run() {
		if (firstMethod.equals("A")) {
			foo.methodA(name);
		} else {
			foo.methodB(name);
		}
	}
}
