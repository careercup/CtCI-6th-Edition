package Q17_10_Majority_Element;

public class QuestionA {
	public static boolean validate(int[] array, int majority) {
		int count = 0;
		for (int n : array) {
			if (n == majority) {
				count++;
			} 
		}
		
		return count > array.length / 2;
	}

	public static int findMajorityElement(int[] array) {
		for (int x : array) {
			if (validate(array, x)) {
				return x;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {0, 0, 1, 2, 2, 0, 1, 0, 1, 1, 1, 1, 1};
		System.out.println(array.length);
		System.out.println(findMajorityElement(array));
	}

}
