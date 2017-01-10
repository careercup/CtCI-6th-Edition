package Q16_16_Sub_Sort;

public class QuestionB {
	public static void findUnsortedSequence(int[] array) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int left_index = -1;
		int right_index = -1;
		
		for (int i=0; i<array.length; i++) {
			if (array[i] >= max) {
				max = array[i];
			} else {
				right_index = i; 
			}
		}
		
		for (int i=array.length-1; i>=0; i--) {
			if (array[i] <= min) {
				min = array[i];
			} else {
				left_index = i; 
			}
		}
		
		if (left_index > -1) {
			System.out.println("TRUE: " + left_index + " " + right_index);
		} else {
			System.out.println("FALSE: " + left_index + " " + right_index);
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] array1 = {1, 9, 4, 3, 5};
		findUnsortedSequence(array1);
		
		int[] array2 = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		findUnsortedSequence(array2);

		int[] array3 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		findUnsortedSequence(array3);

		int[] array4 = {};
		findUnsortedSequence(array4);

		int[] array5 = {4, 4, 4, 4};
		findUnsortedSequence(array5);

		int[] array6 = {5, 2, 4, 7, 10, 11, 12, 16, 18, 19};
		findUnsortedSequence(array6);

		int[] array7 = {2, 4, 7, 10, 11, 7, 16, 18, 19, 5};
		findUnsortedSequence(array7);
	}

}
