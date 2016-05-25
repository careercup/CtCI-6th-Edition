package Q16_11_Diving_Board;

import java.util.HashSet;

public class QuestionA {
	public static int counter = 0;
	
	public static HashSet<Integer> allLengths(int k, int shorter, int longer) {
		HashSet<Integer> lengths = new HashSet<Integer>();
		getAllLengths(k, 0, shorter, longer, lengths);
		return lengths;
	}	
	
	public static void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths) {
		counter++;
		if (k == 0) {
			lengths.add(total);
			return;
		}
		getAllLengths(k - 1, total + shorter, shorter, longer, lengths);
		getAllLengths(k - 1, total + longer, shorter, longer, lengths);
	}

	public static void main(String[] args) {
		HashSet<Integer> lengths = allLengths(12, 1, 3);
		System.out.println(lengths.toString());
		System.out.println(counter);
	}

}
