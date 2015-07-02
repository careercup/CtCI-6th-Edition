package Q16_06_Smallest_Difference;

public class QuestionA {
	public static int findSmallestDifference(int[] array1, int[] array2) {
		if (array1.length == 0 || array2.length == 0) {
			return -1;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (Math.abs(array1[i] - array2[j]) < min) {
					min = Math.abs(array1[i] - array2[j]);
				}
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		int[] array1 = {1, 3, 15, 11, 2};
		int[] array2 = {23, 127, 234, 19, 8};
		int difference = findSmallestDifference(array1, array2);
		System.out.println(difference);
	}

}
