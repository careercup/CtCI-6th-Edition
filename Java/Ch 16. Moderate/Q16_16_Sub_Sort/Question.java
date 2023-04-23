package Q16_16_Sub_Sort;

public class Question {

	public static int findEndOfLeftSubsequence(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return i - 1;
			}
		}
		return array.length - 1;
	}
	
	public static int findStartOfRightSubsequence(int[] array) {
		for (int i = array.length - 2; i >= 0; i--) {
			if (array[i] > array[i + 1]) {
				return i + 1;
			}
		}
		return 0;
	}		
	
	public static int shrinkLeft(int[] array, int min_index, int start) {
		int comp = array[min_index];
		for (int i = start - 1; i >= 0; i--) {
			if (array[i] <= comp) {
				return i + 1;
			}
		}
		return 0;
	}
	
	public static int shrinkRight(int[] array, int max_index, int start) {
		int comp = array[max_index];
		for (int i = start; i < array.length; i++) {
			if (array[i] >= comp) {
				return i - 1;
			}
		}
		return array.length - 1;
	}
	
	public static Range findUnsortedSequence(int[] array) {
		// find left subsequence
		int end_left = findEndOfLeftSubsequence(array);	
		
		if (end_left >= array.length - 1) {
			//System.out.println("The array is already sorted.");
			return new Range(0, 0); // Already sorted
		}
		
		// find right subsequence
		int start_right = findStartOfRightSubsequence(array);		
		
		int max_index = end_left; // max of left side
		int min_index = start_right; // min of right side
		for (int i = end_left + 1; i < start_right; i++) {
			if (array[i] < array[min_index]) {
				min_index = i;
			}
			if (array[i] > array[max_index]) {
				max_index = i;
			}
		}		
		
		// slide left until less than array[min_index]
		int left_index = shrinkLeft(array, min_index, end_left);

		// slide right until greater than array[max_index]
		int right_index = shrinkRight(array, max_index, start_right);
		
		return new Range(left_index, right_index);
	}
	
	/* Validate that sorting between these indices will sort the array. Note that this is not a complete
	 * validation, as it does not check if these are the best possible indices.
	 */
	public static boolean validate(int[] array, int left_index, int right_index) {
		int[] middle = new int[right_index - left_index + 1];
		for (int i = left_index; i <= right_index; i++) {
			middle[i - left_index] = array[i];
		}
		java.util.Arrays.sort(middle);
		for (int i = left_index; i <= right_index; i++) {
			array[i] = middle[i - left_index];
		}
		for (int i = 1; i < array.length; i++) {
			if (array[i-1] > array[i]) {
				return false;
			}		
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 4, 7, 10, 11, 8, 12, 5, 6, 16, 18, 19};
		
		Range r = findUnsortedSequence(array);
		System.out.println(r.toString());
		System.out.println(array[r.start] + ", " + array[r.end]);
	}

}
