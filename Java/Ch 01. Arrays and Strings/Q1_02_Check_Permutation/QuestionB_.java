package Q1_02_Check_Permutation;

public class QuestionB_ {
	public static boolean permutation(String s, String t) {
		if (s.length() != t.length()) return false;
		int[] vector = new int[128];
		for (int i = 0; i < s.length(); i++) {
			vector[s.charAt(i)] += 1;
		}
		for (int i = 0; i < t.length(); i++) {
			int updated = vector[t.charAt(i)] - 1;
			if (updated < 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = permutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
	}
}
