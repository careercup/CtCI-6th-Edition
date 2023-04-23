package Q16_24_Pairs_With_Sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class QuestionB {
	public static ArrayList<Pair> printPairSums(int[] array, int sum) {
		ArrayList<Pair> result = new ArrayList<Pair>();
		HashMap<Integer, Integer> unpairedCount = new HashMap<Integer, Integer>();
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
	
	public static void adjustCounterBy(HashMap<Integer, Integer> counter, int key, int delta) {
		counter.put(key, counter.getOrDefault(key, 0) + delta);
	}
	
	
	public static void main(String[] args) {
		int[] test = {-1, -1, -1, -1, 0, 0, 0, 0, 1, 1};
		ArrayList<Pair> pairs = printPairSums(test, -1);
		for (Pair p : pairs) {
			System.out.println(p.toString());
		}
	}
}
