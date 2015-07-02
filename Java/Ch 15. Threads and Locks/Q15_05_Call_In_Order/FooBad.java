package Q15_05_Call_In_Order;

import java.util.concurrent.locks.ReentrantLock;

public class FooBad {
	public int pauseTime = 1000;
	public ReentrantLock lock1;
	public ReentrantLock lock2;
	
	public FooBad() {	
		try {
			lock1 = new ReentrantLock();
			lock2 = new ReentrantLock();
			
			lock1.lock();
			lock2.lock();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void first() {
		try {
			System.out.println("Started Executing 1");
			Thread.sleep(pauseTime);
			System.out.println("Finished Executing 1");
			lock1.unlock();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void second() {
		try {
			lock1.lock();
			lock1.unlock();
			System.out.println("Started Executing 2");
			Thread.sleep(pauseTime);
			System.out.println("Finished Executing 2");
			lock2.unlock();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	
	
	public void third() {
		try {
			lock2.lock();
			lock2.unlock();
			System.out.println("Started Executing 3");
			Thread.sleep(pauseTime);
			System.out.println("Finished Executing 3");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	
}
