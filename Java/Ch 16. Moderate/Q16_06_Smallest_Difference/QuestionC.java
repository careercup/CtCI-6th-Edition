package Q16_06_Smallest_Difference;
import java.util.Arrays;

public class QuestionC {
	public static int getClosestValue(int[] array, int target) {
		int low = 0;
		int high = array.length - 1;
		int mid;
		
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (array[mid] < target) {
				low = mid + 1;
			} else if (array[mid] > target) {
				high = mid - 1;
			} else {
				return array[mid];
			}
		}
		
		int valueA = low < 0 || low >= array.length ? Integer.MAX_VALUE : array[low];
		int valueB = high < 0 || high >= array.length ? Integer.MAX_VALUE : array[high];
		return Math.abs(valueA - target) < Math.abs(valueB - target) ? valueA : valueB; // return closest value
	}
	
	public static int findSmallestDifference(int[] shorter, int[] longer) {
		if (shorter.length == 0 || longer.length == 0) return -1;
		if (shorter.length > longer.length) return findSmallestDifference(longer, shorter);
		
		Arrays.sort(shorter);
		
		int smallestDifference = Integer.MAX_VALUE;
		for (int target : longer) {
			int closest = getClosestValue(shorter, target);
			smallestDifference = Math.min(smallestDifference, Math.abs(closest - target));
		}
		
		return smallestDifference;
	}
	
	public static void main(String[] args) {
		int[] array1 = {1, 3, 15, 11, 2};
		int[] array2 = {23, 127, 234, 19, 8};
		int difference = findSmallestDifference(array1, array2);
		System.out.println(difference);
	}

}
