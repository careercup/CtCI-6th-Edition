package Q16_06_Smallest_Difference;
import java.util.Arrays;

public class QuestionB {
	public static int findSmallestDifference(int[] array1, int[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);
		int a = 0;
		int b = 0;
		int difference = Integer.MAX_VALUE;
		while (a < array1.length && b < array2.length) {
			if (Math.abs(array1[a] - array2[b]) < difference) {
				difference = Math.abs(array1[a] - array2[b]);
				if (difference == 0) return difference;
			}
			if (array1[a] < array2[b]) {
				a++;
			} else {
				b++;
			}
		}
		return difference;
	}
	
	public static void main(String[] args) {
		int[] array1 = {1, 3, 15, 11, 2};
		int[] array2 = {23, 127, 234, 19, 8};
		int difference = findSmallestDifference(array1, array2);
		System.out.println(difference);
	}

}
