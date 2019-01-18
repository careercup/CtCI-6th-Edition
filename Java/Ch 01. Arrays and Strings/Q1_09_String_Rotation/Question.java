package Q1_09_String_Rotation;

public class Question {
	public static boolean isRotation(String s1, String s2) {
		return s1.length() == s2.length() && (s1 + s1).contains(s2);
	}

	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = isRotation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
	}

}
