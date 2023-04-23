package Big_O;

public class Q_12 {

	public static int binarySearch(int[] a, int x) {
		int low = 0;
		int high = a.length - 1;
		int mid;
		
		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] < x) {
				low = mid + 1;
			} else if (a[mid] > x) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void mergesort(int[] array) {
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length - 1);
	}

	public static void mergesort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(array, helper, low, middle); // Sort left half
			mergesort(array, helper, middle+1, high); // Sort right half
			merge(array, helper, low, middle, high); // Merge them
		}
	}

	public static void merge(int[] array, int[] helper, int low, int middle, int high) {
		/* Copy both halves into a helper array */
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		/* Iterate through helper array. Compare the left and right
		 * half, copying back the smaller element from the two halves
		 * into the original array. */
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else { // If right element is smaller than left element
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}

		/* Copy the rest of the left side of the array into the
		 * target array */
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}	
	
	public static int intersection(int[] a, int[] b) {
		mergesort(b);
		int intersect = 0;
		
		for (int x : a) {
			if (binarySearch(b, x) >= 0) {
				intersect++;
			}
		}
		
		return intersect;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7};
		int[] b = {1, 9, 2, 7};
		int x = intersection(a, b);
		System.out.println(x);
	}
}
