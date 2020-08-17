package Q1_01_Is_Unique;

public class QuestionB_ {

	/* Assumes only letters a through z. */
	public static boolean isUniqueChars(String str) {
		if (str.length() > 26) {
			return false;
		}
		int check = 0;
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			if((check & (1 << index)) > 0) {
				return false;
			}
			check |= (1 << index);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}

}
