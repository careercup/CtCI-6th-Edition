package Q16_21_Sum_Swap;

public class QuestionB {
	public static int[] findSwapValues(int[] array1, int[] array2) {
		Integer target = getTarget(array1, array2);
		if (target == null) return null;
				
		for (int one : array1) {
			for (int two : array2) {
				if (one - two == target) {
					int[] values = {one, two};
					return values;
				}
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
	
	public static int sum(int[] array) {
		int s = 0;
		for (int a : array) {
			s += a;
		}
		return s;
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
