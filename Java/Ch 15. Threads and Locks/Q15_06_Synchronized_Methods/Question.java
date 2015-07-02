package Q15_06_Synchronized_Methods;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* Part 1 Demo -- same instance */
		System.out.println("Part 1 Demo with same instance.");
		Foo fooA = new Foo("ObjectOne");
		MyThread thread1a = new MyThread(fooA, "Dog", "A");
		MyThread thread2a = new MyThread(fooA, "Cat", "A");
		thread1a.start();
		thread2a.start();
		while (thread1a.isAlive() || thread2a.isAlive()) { };
		System.out.println("\n\n");
		
		/* Part 1 Demo -- difference instances */
		System.out.println("Part 1 Demo with different instances.");
		Foo fooB1 = new Foo("ObjectOne");
		Foo fooB2 = new Foo("ObjectTwo");
		MyThread thread1b = new MyThread(fooB1, "Dog", "A");
		MyThread thread2b = new MyThread(fooB2, "Cat", "A");
		thread1b.start();
		thread2b.start();
		while (thread1b.isAlive() || thread2b.isAlive()) { };
		System.out.println("\n\n");
		
		/* Part 2 Demo */
		System.out.println("Part 2 Demo.");
		Foo fooC = new Foo("ObjectOne");
		MyThread thread1c = new MyThread(fooC, "Dog", "A");
		MyThread thread2c = new MyThread(fooC, "Cat", "B");
		thread1c.start();
		thread2c.start();		
	}

}
