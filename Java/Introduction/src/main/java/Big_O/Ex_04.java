package Big_O;

public class Ex_04 {
	public static void foo(int[] arrA, int[] arrB) {
		for (int a : arrA) {
			System.out.println(a);
		}
		for (int b : arrB) {
			System.out.println(b);
		}
	}
	
	public static void bar(int[] arrA, int[] arrB) {
		for (int a : arrA) {
			for (int b : arrB) {
				System.out.println(a + "," + b);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arrA = {1, 2, 5, 2, 2, 5, -1, 9, 3};
		int[] arrB = {5, 2, 1, 0, 2};
		foo(arrA, arrB);
		bar(arrA, arrB);
	}		
}
