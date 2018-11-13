package Q16_16_Sub_Sort;

public class QuestionB {
	
	public static int findRightSequenceStart(int[] array) {
		int max = Integer.MIN_VALUE;
		int lastNo = 0;
		for (int i = 0; i < array.length; i++) {
			if (max > array[i]) {
				lastNo = i;
			}
			max = Math.max(array[i], max);
		}
		return lastNo;
	}
	
	public static int findLeftSequenceEnd(int[] array) {
		int min = Integer.MAX_VALUE;
		int lastNo = 0;
		for (int i = array.length - 1; i >= 0; i--) {
			if (min < array[i]) {
				lastNo = i;
			}
			min = Math.min(array[i], min);
		}
		return lastNo;
	}
	
	public static Range findUnsortedSequence(int[] array) {
		int leftSequenceEnd = findRightSequenceStart(array);
		int rightSequenceEnd = findLeftSequenceEnd(array);
		return new Range(leftSequenceEnd, rightSequenceEnd);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 4, 7, 10, 11, 8, 12, 5, 6, 16, 18, 19};
		Range r = findUnsortedSequence(array);
		System.out.println(r.toString());
		System.out.println(array[r.start] + ", " + array[r.end]);
	}

}
