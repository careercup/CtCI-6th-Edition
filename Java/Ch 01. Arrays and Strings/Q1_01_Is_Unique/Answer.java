public class Answer {
	public static boolean isUnique(String str) {
		for(int i = 0; i < str.length(); i++){
			for(int j = i + 1; j<str.length(); j++){
				if (str.charAt(i) == str.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUnique(word));
		}
	}

}