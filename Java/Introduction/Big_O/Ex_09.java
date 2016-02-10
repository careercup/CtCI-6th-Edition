package Big_O;

public class Ex_09 {
	public static void printUnorderedPairs(int[] arrayA, int[] arrayB) {
		for (int valueA : arrayA) {
			for (int valueB : arrayB) {
				if (valueA < valueB) {
					System.out.println(valueA + "," + valueB);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arrayA = {0, 1, 2, 3};
		int[] arrayB = {4, 5, 6};
		printUnorderedPairs(arrayA, arrayB);
	}		
}
