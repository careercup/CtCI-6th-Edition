package Q17_18_Shortest_Supersequence;

public class QuestionA {
	/* Find next instance of element starting from index. */
	public static int findNextInstance(int[] array, int element, int index) {
		for (int i = index; i < array.length; i++) {
			if (array[i] == element) {
				return i;
			}
		}
		return -1;
	}
	
	/* Given an index, find the closure (i.e., the element which terminates a complete
	 * subarray containing all elements in smallArray). This will be the max of the
	 * next locations of each element in smallArray. */
	public static int findClosure(int[] bigArray, int[] smallArray, int index) {
		int max = -1;
		for (int i = 0; i < smallArray.length; i++) {
			int next = findNextInstance(bigArray, smallArray[i], index);
			if (next == -1) {
				return -1;
			}
			max = Math.max(next,  max);
		}
		return max;
	}
	
	public static Range shortestSupersequence(int[] bigArray, int[] smallArray) {
		int bestStart = -1;
		int bestEnd = -1;
		for (int i = 0; i < bigArray.length; i++) {
			int end = findClosure(bigArray, smallArray, i);
			if (end == -1) break;
			if (bestStart == -1 || end - i < bestEnd - bestStart) {
				bestStart = i;
				bestEnd = end;
			}
		}
		if (bestStart < 0 || bestEnd < 0) {
			return null;
		}
		return new Range(bestStart, bestEnd);
	}
	
	public static void main(String[] args) {
		int[] array = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 9, 7};
		int[] set = {1, 5, 9};
		System.out.println(array.length);
		Range shortest = shortestSupersequence(array, set);
		System.out.println(shortest.getStart() + ", " + shortest.getEnd());
	}
}
