package Q15_04_Deadlock_Free_Class;

public class Question {

	public static void main(String[] args) {
		int[] res1 = {1, 2, 3, 4};
		int[] res2 = {1, 5, 4, 1};
		int[] res3 = {1, 4, 5};
		
		LockFactory.initialize(10);
		
		LockFactory lf = LockFactory.getInstance();
		System.out.println(lf.declare(1, res1));
		System.out.println(lf.declare(2, res2));
		System.out.println(lf.declare(3, res3));	
		
		System.out.println(lf.getLock(1, 1));
		System.out.println(lf.getLock(1, 2));
		System.out.println(lf.getLock(2, 4));
	}

}
