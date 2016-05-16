package Q16_11_Diving_Board;

import java.util.HashSet;

public class QuestionC {
	public static int counter = 0;
	
	public static HashSet<Integer> allLengths(int k, int shorter, int longer) {
		counter++;
		HashSet<Integer> lengths = new HashSet<Integer>();
		for (int nShorter = 0; nShorter <= k; nShorter++) {
			int nLonger = k - nShorter;
			int length = nShorter * shorter + nLonger * longer;
			lengths.add(length);
		}
		return lengths;
	}
	
	public static void main(String[] args) {
		HashSet<Integer> lengths = allLengths(12, 1, 3);
		System.out.println(lengths.toString());
	}

}
