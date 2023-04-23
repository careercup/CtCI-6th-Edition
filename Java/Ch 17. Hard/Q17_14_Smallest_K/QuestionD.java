package Q17_14_Smallest_K;

import java.util.Random;

import CtCILibrary.AssortedMethods;

public class QuestionD {
	public static class PartitionResult {
		int leftSize;
		int middleSize;
		public PartitionResult(int left, int middle) {
			this.leftSize = left;
			this.middleSize = middle;
		}
	}
	
	public static int[] smallestK(int[] array, int k) {
		if (k <= 0 || k > array.length) throw new IllegalArgumentException();
		
		int threshold = rank(array, k - 1);
		int[] smallest = new int[k];
		int count = 0;
		for (int a : array) {
			if (a < threshold) {
				smallest[count] = a;
				count++;
			}
		}
		
		while (count < k) {
			smallest[count] = threshold;
			count++;
		}
		
		return smallest;
	}	
	
	/* Find value with rank k in array. */
	public static int rank(int[] array, int k) {
		if (k >= array.length) {
			throw new IllegalArgumentException();
		}
		return rank(array, k, 0, array.length - 1);
	}
 
	/* Find value with rank k in sub array between start and end. */
	private static int rank(int[] array, int k, int start, int end) {
		/* Partition array around an arbitrary pivot. */
		int pivot = array[randomIntInRange(start, end)];
		PartitionResult partition = partition(array, start, end, pivot);
		int leftSize = partition.leftSize;
		int middleSize = partition.middleSize;
		
		if (k < leftSize) { // Rank k is on left half
			return rank(array, k, start, start + leftSize - 1);
		} else if (k < leftSize + middleSize) { // Rank k is in middle
			return pivot; // middle is all pivot values
		} else { // Rank k is on right
			return rank(array, k - leftSize - middleSize, start + leftSize + middleSize, end);
		}
	}
 
	/* Partition result into < pivot, equal to pivot -> bigger than pivot. */
	private static PartitionResult partition(int[] array, int start, int end, int pivot) {
		int left = start; /* Stays at (right) edge of left side. */
		int right = end;  /* Stays at (left) edge of right side. */
		int middle = start; /* Stays at (right) edge of middle. */
		while (middle <= right) {
			if (array[middle] < pivot) {
				/* Middle is smaller than the pivot. Left is either 
				 * smaller or equal to the pivot. Either way, swap
				 * them. Then middle and left should move by one.
				 */
				swap(array, middle, left);
				middle++;
				left++;
			} else if (array[middle] > pivot) {
				/* Middle is bigger than the pivot. Right could have
				 * any value. Swap them, then we know that the new
				 * right is bigger than the pivot. Move right by one.
				 */
				swap(array, middle, right);
				right--;
			} else if (array[middle] == pivot) {
				/* Middle is equal to the pivot. Move by one. */
				middle++;
			}
		}
		/* Return sizes of left and middle. */
		return new PartitionResult(left - start, right - left + 1);
	}
	
	public static int randomIntInRange(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max + 1 - min) + min;
	}	
 
	/* Swap values at index i and j. */
	public static void swap(int[] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}	
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 3, 2, 9, -1, 11, 6, 13, 15, 2};
		int[] smallest = smallestK(array, 6);
		System.out.println(AssortedMethods.arrayToString(smallest));
	}
}
