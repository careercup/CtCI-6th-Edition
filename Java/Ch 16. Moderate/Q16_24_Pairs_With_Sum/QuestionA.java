package Q16_24_Pairs_With_Sum;

import java.util.ArrayList;
import java.util.List;

public class QuestionA {
	public static List<Pair> printPairSums(int[] array, int sum) {
		List<Pair> result = new ArrayList<>();
		for (int i = 0 ; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] == sum) {
					result.add(new Pair(array[i], array[j]));
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] test = {9, 3, 6, 5, 5, 7, -1, 13, 14, -2, 12, 0};
		List<Pair> pairs = printPairSums(test, 12);
		for (Pair p : pairs) {
			System.out.println(p.toString());
		}
	}
}
