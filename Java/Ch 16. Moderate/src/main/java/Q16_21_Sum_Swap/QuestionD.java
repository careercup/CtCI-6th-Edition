package Q16_21_Sum_Swap;

import java.util.Arrays;
import java.util.HashSet;

public class QuestionD {
	
	public static int sum(int[] array) {
		int s = 0;
		for (int a : array) {
			s += a;
		}
		return s;
	}
	
	public static Integer getTarget(int[] array1, int[] array2) {
		int sum1 = sum(array1);
		int sum2 = sum(array2);
		
		if ((sum1 - sum2) % 2 != 0) return null;
		return (sum1 - sum2) / 2;
	}
	
	public static int[] findSwapValues(int[] array1, int[] array2) {
		Integer target = getTarget(array1, array2);
		if (target == null) return null;
		return findDifference(array1, array2, target);
	}
	
	public static int[] findDifference(int[] array1, int[] array2, int target) {
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		int a = 0;
		int b = 0;
		
		while (a < array1.length && b < array2.length) {
			int difference = array1[a] - array2[b]; 
			/* Compare difference to target. If difference is too small, then
			 * make it bigger by moving a to a bigger value. If it is too big,
			 * then make it smaller by moving b to a bigger value. If it's
			 * just right, return this pair. */
			if (difference == target) {
				int[] values = {array1[a], array2[b]};
				return values;
			} else if (difference < target) { 
				a++;
			} else {
				b++;
			}
		}
		
		return null;
	}

	public static void main(String[] args) {
		int[] array1 = {1, 1, 1, 2, 2, 4};
		int[] array2 = {3, 3, 3, 6};
		int[] swaps = findSwapValues(array1, array2);
		if (swaps == null) {
			System.out.println("null");
		} else {
			System.out.println(swaps[0] + " " + swaps[1]);
		}
	}

}
