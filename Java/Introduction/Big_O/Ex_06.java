package Big_O;

public class Ex_06 {
	public static void foo(int[] array) {
		int sum = 0;
		int product = 1;
		for (int value : array) {
			sum += value;
		}
		for (int value : array) {
			product *= value;
		}	
		System.out.println(sum + ", " + product);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 5, 2, 2, 5, -1, 9, 3};
		foo(array);
	}		
}
