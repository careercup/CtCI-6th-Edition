package Q16_11_Diving_Board;

import java.util.HashSet;

public class QuestionB {
	public static int counter = 0;
	
	public static HashSet<Integer> allLengths(int k, int shorter, int longer) {
		HashSet<Integer> lengths = new HashSet<Integer>();
		HashSet<String> visited = new HashSet<String>(); 
		getAllLengths(k, 0, shorter, longer, lengths, visited);
		return lengths;
	}	
	
	public static void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths, HashSet<String> visited) {
		counter++;
		if (k == 0) {
			lengths.add(total);
			return;
		}
		String key = k + " " + total;
		if (visited.contains(key)) {
			return;
		}
		getAllLengths(k - 1, total + shorter, shorter, longer, lengths, visited);
		getAllLengths(k - 1, total + longer, shorter, longer, lengths, visited);
		visited.add(key);
	}
	
	public static void main(String[] args) {
		HashSet<Integer> lengths = allLengths(12, 1, 3);
		System.out.println(lengths.toString());
		System.out.println(counter);
	}

}
