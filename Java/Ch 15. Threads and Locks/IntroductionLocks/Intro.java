package IntroductionLocks;

public class Intro {

	public static void main(String[] args) {
		NoLockATM noLockATM = new NoLockATM();
		LockedATM lockedATM = new LockedATM();
		MyClass thread1 = new MyClass(noLockATM, lockedATM);
		MyClass thread2 = new MyClass(noLockATM, lockedATM);
		
		thread1.start();
		thread2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread1.waitUntilDone();
		thread2.waitUntilDone();
		
		System.out.println("NoLock ATM: " + noLockATM.getBalance());
		System.out.println("Locked ATM: " + lockedATM.getBalance());
		int v = thread1.delta + thread2.delta + 100;
		System.out.println("Should Be: " + v);
		System.out.println("Program terminating.");
	}

}
