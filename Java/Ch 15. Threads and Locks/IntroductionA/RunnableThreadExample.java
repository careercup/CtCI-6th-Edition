package IntroductionA;

public class RunnableThreadExample implements Runnable {
	public int count = 0;

	public void run() {
		System.out.println("RunnableThread starting.");
		try {
			while (count < 5) {
				Thread.sleep(500);
				System.out.println("RunnableThread count: " + count);
				count++;
			} 
		} catch (InterruptedException exc) {
			System.out.println("RunnableThread interrupted.");
		}
		System.out.println("RunnableThread terminating.");
	}
}
