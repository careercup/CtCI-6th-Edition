package Q1_09_String_Rotation;

public class Question {
	private static boolean isSubstring(String big, String small) {
		return big.contains(small);
	}

	public static boolean isRotation(String s1, String s2) {
		return s1.length() == s2.length()
			   && isSubstring(s1 + s1, s2);
	}
	
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"},
							{"waterbottle", "erbottlewat"},
							{"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			System.out.println(word1 + ", " + word2 + ": " + isRotation(word1, word2));
		}
	}
}
