package Big_O;

public class Ex_07 {
	public static void printPairs(int[] array) {
		for (int value1 : array) {
			for (int value2 : array) {
				System.out.println(value1 + "," + value2);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3};
		printPairs(array);
	}		
}
