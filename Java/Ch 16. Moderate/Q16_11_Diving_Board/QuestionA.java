package Q16_11_Diving_Board;

import java.util.HashSet;
import java.util.Set;

public class QuestionA {
	public static int counter = 0;

	public static Set<Integer> allLengths(int k, int shorter, int longer) {
		Set<Integer> lengths = new HashSet<>();
		getAllLengths(k, 0, shorter, longer, lengths);
		return lengths;
	}

	public static void getAllLengths(int k, int total, int shorter, int longer, Set<Integer> lengths) {
		counter++;
		if (k == 0) {
			lengths.add(total);
			return;
		}
		getAllLengths(k - 1, total + shorter, shorter, longer, lengths);
		getAllLengths(k - 1, total + longer, shorter, longer, lengths);
	}

	public static void main(String[] args) {
		Set<Integer> lengths = allLengths(12, 1, 3);
		System.out.println(lengths);
		System.out.println(counter);
	}

}
