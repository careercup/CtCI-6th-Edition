package Q16_24_Pairs_With_Sum;

import java.util.ArrayList;
import java.util.HashSet;

public class QuestionB {	
	public static ArrayList<Pair> printPairSums(int[] array, int sum) {
		ArrayList<Pair> result = new ArrayList<Pair>();
		HashSet<Integer> elements = new HashSet<Integer>();
		for (int x : array) {
			int complement = sum - x;
			if (elements.contains(complement) && !elements.contains(x)) {
				result.add(new Pair(x, complement));
			}
			elements.add(x);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] test = {9, 3, 6, 5, 7, 7, -1, 13, 14, -2, 12, 0};
		ArrayList<Pair> pairs = printPairSums(test, 12);
		for (Pair p : pairs) {
			System.out.println(p.toString());
		}
	}
}
