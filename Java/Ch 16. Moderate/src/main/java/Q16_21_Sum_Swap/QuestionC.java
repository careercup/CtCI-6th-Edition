package Q16_21_Sum_Swap;

import java.util.HashSet;

public class QuestionC {
	
	public static int sum(int[] array) {
		int s = 0;
		for (int a : array) {
			s += a;
		}
		return s;
	}
	
	public static int[] findSwapValues(int[] array1, int[] array2) {
		Integer target = getTarget(array1, array2);
		if (target == null) return null;
		return findDifference(array1, array2, target);
	}
	
	public static int[] findDifference(int[] array1, int[] array2, int target) {
		HashSet<Integer> contents2 = getContents(array2);
		for (int one : array1) {
			int two = one - target;
			if (contents2.contains(two)) {
				int[] values = {one, two};
				return values;
			}
		}
		
		return null;
	}
	
	public static Integer getTarget(int[] array1, int[] array2) {
		int sum1 = sum(array1);
		int sum2 = sum(array2);
		
		if ((sum1 - sum2) % 2 != 0) return null;
		return (sum1 - sum2) / 2;
	}
	
	public static HashSet<Integer> getContents(int[] array) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int a : array) {
			set.add(a);
		}
		return set;
	}

	public static void main(String[] args) {
		int[] array1 = {-9, -1, -4, 8, 9, 6, -5, -7, 3, 9};
		int[] array2 = {6, 6, 4, -1, 7, -6, -9, 4, -8, 8};
		int[] swaps = findSwapValues(array1, array2);
		if (swaps == null) {
			System.out.println("null");
		} else {
			System.out.println(swaps[0] + " " + swaps[1]);
		}
	}

}
