package Q16_24_Pairs_With_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionC {
	public static List<Pair> printPairSums(int[] array, int sum) {
		List<Pair> result = new ArrayList<>();
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int s = array[first] + array[last];
			if (s == sum) {
				result.add(new Pair(array[first], array[last]));
				++first;
				--last;
			} else {
				if (s < sum) {
					++first;
				} else {
					--last;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] test = {9, 3, 6, 5, 7, 7, -1, 13, 14, -2, 12, 0};
		List<Pair> pairs = printPairSums(test, 12);
		for (Pair p : pairs) {
			System.out.println(p);
		}
	}
}
