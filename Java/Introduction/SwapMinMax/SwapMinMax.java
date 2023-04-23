package SwapMinMax;

import CtCILibrary.AssortedMethods;

public class SwapMinMax {
	
	public static int getMinIndex(int[] array) {
		int minIndex = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public static int getMaxIndex(int[] array) {
		int maxIndex = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	public static void swap(int[] array, int m, int n) {
		int temp = array[m];
		array[m] = array[n];
		array[n] = temp;
	}
	
	public static void swapMinMaxBetter(int[] array) {
		int minIndex = getMinIndex(array);
		int maxIndex = getMaxIndex(array);
		swap(array, minIndex, maxIndex);
	}

	public static void swapMinMax(int[] array) {
		int minIndex = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[minIndex]) {
				minIndex = i;
			}
		}
		
		int maxIndex = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[maxIndex]) {
				maxIndex = i;
			}
		}
		
		int temp = array[minIndex];
		array[minIndex] = array[maxIndex];
		array[maxIndex] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = AssortedMethods.randomArray(10, -10, 10);
		System.out.println(AssortedMethods.arrayToString(array));
		swapMinMaxBetter(array);
		System.out.println(AssortedMethods.arrayToString(array));
	}

}
