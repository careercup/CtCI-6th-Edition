package Q10_04_Sorted_Search_No_Size.Arrayish;

public class Question {

	public static int binarySearch(Listy list, int value, int low, int high) {
		int mid;
		
		while (low <= high) {
			mid = (low + high) / 2;
			int middle = list.elementAt(mid);
			if (middle > value || middle == -1) {
				high = mid - 1;
			} else if (middle < value) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;		
	}
	
	public static int search(Listy list, int value) {
		int index = 1;
		while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
			index *= 2;
		}
		return binarySearch(list, value, index / 2, index);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18};
		Listy list = new Listy(array);
		for (int a : array) {
			System.out.println(search(list, a));
		}
		System.out.println(search(list, 15));
	}

}
