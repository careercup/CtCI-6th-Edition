package Q17_14_Smallest_K;

import java.util.Random;

import CtCILibrary.AssortedMethods;

public class QuestionC {
	
	public static int[] smallestK(int[] array, int k) {
		if (k <= 0 || k > array.length) {
			throw new IllegalArgumentException();
		}
		
		int threshold = rank(array, k - 1);
		int[] smallest = new int[k];
		int count = 0;
		for (int a : array) {
			if (a <= threshold) {
				smallest[count] = a;
				count++;
			}
		}
		return smallest;
	}
	
	/* Get item with rank. */
	public static int rank(int[] array, int rank) {
		return rank(array, 0, array.length - 1, rank);
	}
	
	/* Get element with rank between left and right indices. */
	public static int rank(int[] array, int left, int right, int rank) {
		int pivot = array[randomIntInRange(left, right)];
		int leftEnd = partition(array, left, right, pivot); // returns end of left partition
		int leftSize = leftEnd - left + 1;
		if (rank == leftSize - 1) {
			return max(array, left, leftEnd);
		} else if (rank < leftSize) {
			return rank(array, left, leftEnd, rank);
		} else {
			return rank(array, leftEnd + 1, right, rank - leftSize);
		}
	}
	
	/* Partition array around pivot such that all elements <= pivot
	 * come before all elements > pivot. */
	public static int partition(int[] array, int left, int right, int pivot) {
		while (left <= right) {
			if (array[left] > pivot) {
				/* Left is bigger than pivot. Swap it to the right
				 * side, where we know it should be. */
				swap(array, left, right);
				right--;
			} else if (array[right] <= pivot) {
				/* Right is smaller than the pivot. Swap it to the 
				 * left side, where we know it should be. */
				swap(array, left, right);
				left++;
			} else {
				/* Left and right are in correct places. Expand both
				 * sides. */
				left++;
				right--;
			}
		}
		return left - 1;
	} 
	
	/* Get random integer within range, inclusive. */
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
	
	/* Get largest element in array between left and right indices. */
	public static int max(int[] array, int left, int right) {
		int max = Integer.MIN_VALUE;
		for (int i = left; i <= right; i++) {
			max = Math.max(array[i], max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 9, -1, 11, 6, 13, 15};
		int[] smallest = smallestK(array, 3);
		System.out.println(AssortedMethods.arrayToString(smallest));
	}

}
