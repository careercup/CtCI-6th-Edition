package IntroductionSynchronizedBlocks;

public class Intro {

	public static void main(String[] args) {
		try {
			MyObject obj1 = new MyObject();
			MyObject obj2 = new MyObject();
			
			MyClass thread1 = new MyClass(obj1, "1");
			MyClass thread2 = new MyClass(obj1, "2");
			
			thread1.start();
			thread2.start();
			
			Thread.sleep(3000 * 3);
		}  catch (InterruptedException exc) {
			System.out.println("Program Interrupted.");
		}
		System.out.println("Program terminating.");
	}

}
