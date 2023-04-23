package Q10_03_Search_in_Rotated_Array;

public class Question {
	
	public static int search(int a[], int x) {
		return search(a, 0, a.length - 1, x);
	}

	
	public static int search(int a[], int left, int right, int x) {
		int mid = (left + right) / 2;
		if (x == a[mid]) { // Found element
			return mid;
		}
		if (right < left) {
			return -1;
		}
		
		/* While there may be an inflection point due to the rotation, either the left or 
		 * right half must be normally ordered.  We can look at the normally ordered half
		 * to make a determination as to which half we should search. 
		 */
		if (a[left] < a[mid]) { // Left is normally ordered.
			if (x >= a[left] && x < a[mid]) { 
				return search(a, left, mid - 1, x);
			} else {
				return search(a, mid + 1, right, x);
			}
		} else if (a[mid] < a[right]) { // Right is normally ordered.
			if (x > a[mid] && x <= a[right]) {
				return search(a, mid + 1, right, x);
			} else {
				return search(a, left, mid - 1, x);
			}				
		} else if (a[left] == a[mid]) { // Left is either all repeats OR loops around (with the right half being all dups)
			if (a[mid] != a[right]) { // If right half is different, search there
				return search(a, mid + 1, right, x);
			} else { // Else, we have to search both halves
				int result = search(a, left, mid - 1, x); 
				if (result == -1) {
					return search(a, mid + 1, right, x); 
				} else {
					return result;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 1, 2, 2, 2, 2, 2 , 2 , 2 };

		System.out.println(search(a, 2));
		System.out.println(search(a, 3));
		System.out.println(search(a, 4));
		System.out.println(search(a, 1));
		System.out.println(search(a, 8));
	}

}
