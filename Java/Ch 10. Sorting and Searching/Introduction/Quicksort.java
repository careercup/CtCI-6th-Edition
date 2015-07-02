package Introduction;

public class Quicksort {
	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static int partition(int arr[], int left, int right) {
		int pivot = arr[(left + right) / 2]; // Pick a pivot point. Can be an element.
		System.out.println(pivot);
		
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
	
	public static void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right); 
		if (left < index - 1) { // Sort left half
			quickSort(arr, left, index - 1);
		}
		if (index < right) { // Sort right half
			quickSort(arr, index, right);
		}
	}
	
	public static void main(String[] args) {
		/*int[] arr = AssortedMethods.randomArray(20, 0, 20);
		AssortedMethods.printIntArray(arr);	
		quickSort(arr, 0, arr.length - 1);
		AssortedMethods.printIntArray(arr);*/
		int[] arr = {3,1,8,5,6,2,7,4};
		int p = partition(arr, 0, arr.length - 1);
		System.out.println("pivot index is " + p + " pivot value is " + arr[p]);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

}
