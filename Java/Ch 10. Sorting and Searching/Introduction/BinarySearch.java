package Introduction;

public class BinarySearch {

	public static int binarySearch(int[] a, int x) {
		int low = 0;
		int high = a.length - 1;
		int mid;
		
		while (low <= high) {
			mid = low + (high - low) / 2;
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
	
	public static int binarySearchRecursive(int[] a, int x, int low, int high) {
		if (low > high) return -1; // Error
		
		int mid = (low + high) / 2;
		if (a[mid] < x) {
			return binarySearchRecursive(a, x, mid + 1, high);
		} else if (a[mid] > x) {
			return binarySearchRecursive(a, x, low, mid - 1);
		} else {
			return mid;
		}
	}
	
	// Recursive algorithm to return the closest element
	public static int binarySearchRecursiveClosest(int[] a, int x, int low, int high) {
		if (low > high) { // high is on the left side now
			if (high < 0) return low;
			if (low >= a.length) return high;
			if (x - a[high] < a[low] - x) {
				return high;
			} 
			return low;
		}
		
		int mid = (low + high) / 2;
		if (a[mid] < x) {
			return binarySearchRecursiveClosest(a, x, mid + 1, high);
		} else if (a[mid] > x) {
			return binarySearchRecursiveClosest(a, x, low, mid - 1);
		} else {
			return mid;
		}
	}	
	
	public static void main(String[] args) {
		int[] array = {3, 6, 9, 12, 15, 18};
		for (int i = 0; i < 20; i++) {
			int loc = binarySearch(array, i);
			int loc2 = binarySearchRecursive(array, i, 0, array.length - 1);
			int loc3 = binarySearchRecursiveClosest(array, i, 0, array.length - 1);
			System.out.println(i + ": " + loc + " " + loc2 + " " + loc3);
		}
	}

}
