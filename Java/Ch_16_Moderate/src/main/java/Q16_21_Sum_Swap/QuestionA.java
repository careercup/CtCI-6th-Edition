package Q16_21_Sum_Swap;

public class QuestionA {
	
	public static int sum(int[] array) {
		int s = 0;
		for (int a : array) {
			s += a;
		}
		return s;
	}
	
	public static int[] findSwapValues(int[] array1, int[] array2) {
		int sum1 = sum(array1);
		int sum2 = sum(array2);
				
		for (int one : array1) {
			for (int two : array2) {
				int newSum1 = sum1 - one + two;
				int newSum2 = sum2 - two + one;
				if (newSum1 == newSum2) {
					int[] values = {one, two};
					return values;
				}
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
