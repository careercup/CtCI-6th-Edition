package Big_O;

public class Ex_07 {
	public static void printPairs(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.println(array[i] + "," + array[j]);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3};
		printPairs(array);
	}		
}
