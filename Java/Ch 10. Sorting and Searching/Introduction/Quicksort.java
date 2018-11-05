package Introduction;

import CtCILibrary.AssortedMethods;

public class Quicksort {
	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[left + (right - left) / 2]; // Pick a pivot point. Can be an element		
		
		while (left <= right) { // Until we've gone through the whole array
			// Find element on left that should be on right
			while (arr[left] < pivot) { 
				left++;
			}
			
			// Find element on right that should be on left
			while (arr[right] > pivot) {
				right--;
			}
			
			// Swap elements, and move left and right indices
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left; 
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		int index = partition(arr, left, right); 
		if (left < index - 1) { // Sort left half
			quickSort(arr, left, index - 1);
		}
		if (index < right) { // Sort right half
			quickSort(arr, index, right);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = AssortedMethods.randomArray(20, 0, 6);
		AssortedMethods.printIntArray(arr);	
		quickSort(arr, 0, arr.length - 1);
		AssortedMethods.printIntArray(arr);
	}

}
