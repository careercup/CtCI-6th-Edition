package Q16_06_Smallest_Difference;
import java.util.Arrays;

public class QuestionB {
	public static int findSmallestDifference(int[] arrayA, int[] arrayB) {
		if (arrayA.length == 0 || arrayB.length == 0) return -1;
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		int indexA = 0;
		int indexB = 0;
		int smallestDifference = Integer.MAX_VALUE;
		while (indexA < arrayA.length && indexB < arrayB.length) {
			int difference = Math.abs(arrayA[indexA] - arrayB[indexB]);
			smallestDifference = Math.min(smallestDifference, difference);

			if (arrayA[indexA] < arrayB[indexB]) {
				indexA++;
			} else {
				indexB++;
			}
		}
		return smallestDifference;
	}
	
	public static void main(String[] args) {
		int[] array1 = {1, 3, 15, 11, 2};
		int[] array2 = {23, 127, 234, 19, 8};
		int difference = findSmallestDifference(array1, array2);
		System.out.println(difference);
	}

}
