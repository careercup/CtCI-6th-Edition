package Q16_11_Diving_Board;

import java.util.HashSet;
import java.util.Set;

public class QuestionC {
	public static int counter = 0;

	public static Set<Integer> allLengths(int k, int shorter, int longer) {
		counter++;
		Set<Integer> lengths = new HashSet<>();
		for (int nShorter = 0; nShorter <= k; nShorter++) {
			int nLonger = k - nShorter;
			int length = nShorter * shorter + nLonger * longer;
			lengths.add(length);
		}
		return lengths;
	}
	
	public static void main(String[] args) {
		Set<Integer> lengths = allLengths(12, 1, 3);
		System.out.println(lengths);
	}

}
