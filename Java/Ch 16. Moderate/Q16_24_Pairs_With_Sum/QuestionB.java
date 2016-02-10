package Q16_24_Pairs_With_Sum;

import java.util.*;

public class QuestionB {
	public static List<Pair> printPairSums(int[] array, int sum) {
		List<Pair> result = new ArrayList<>();
		Map<Integer, Integer> unpairedCount = new HashMap<>();
		for (int x : array) {
			int complement = sum - x;
			if (unpairedCount.getOrDefault(complement, 0) > 0) {
				result.add(new Pair(x, complement));
				adjustCounterBy(unpairedCount, complement, -1); // decrement complement
			} else {
				adjustCounterBy(unpairedCount, x, 1); // increment x
			}
		}
		return result;
	}

	public static void adjustCounterBy(Map<Integer, Integer> counter, int key, int delta) {
		counter.put(key, counter.getOrDefault(key, 0) + delta);
	}

	public static void main(String[] args) {
		int[] test = {-1, -1, -1, -1, 0, 0, 0, 0, 1, 1};
		List<Pair> pairs = printPairSums(test, -1);
		for (Pair p : pairs) {
			System.out.println(p.toString());
		}
	}
}
