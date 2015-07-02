package Big_O;

public class Ex_06 {
	public static void foo(int[] array) {
		int sum = 0;
		int product = 1;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		for (int i = 0; i < array.length; i++) {
			product *= array[i];
		}	
		System.out.println(sum + ", " + product);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 5, 2, 2, 5, -1, 9, 3};
		foo(array);
	}		
}
