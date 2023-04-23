package Q16_18_Pattern_Matcher;

public class QuestionB {
	
	public static String formStringFromPattern(String pattern, String first, String second) {
		if (pattern.length() == 0) return null;
		
		StringBuffer sb = new StringBuffer();
		char firstChar = pattern.charAt(0);
		for (char c : pattern.toCharArray()) {
			if (c == firstChar) {
				sb.append(first);
			} else if (c != firstChar) {
				sb.append(second);
			} else {
				return null;
			}
		}
		return sb.toString();
	}
	
	public static int countOf(String pattern, char ch) {
		int count = 0;
		for (char c : pattern.toCharArray()) {
			if (c == ch) {
				count++;
			}
		}
		return count;
	}
	
	public static String canonical(String pattern) {
		if (pattern.charAt(0) == 'a') return pattern;
		StringBuffer sb = new StringBuffer();
		for (char c : pattern.toCharArray()) {
			if (c == 'a') {
				sb.append('b');
			} else {
				sb.append('a');
			}
		}
		return sb.toString();
	}

	public static boolean doesMatch(String pattern, String value) {
		if (pattern.length() == 0) return value.length() == 0;
		
		pattern = canonical(pattern);

		int countOfAs = countOf(pattern, 'a');
		int countOfBs = pattern.length() - countOfAs;
		int firstB = pattern.indexOf('b');
		
		for (int aSize = 0; aSize <= value.length() / countOfAs; aSize++) {
			int remainingLength = value.length() - aSize * countOfAs;
			String first = value.substring(0, aSize);
			if (countOfBs == 0 || remainingLength % countOfBs == 0) {
				int bIndex = firstB * aSize;
				int bSize = countOfBs == 0 ? 0 : remainingLength / countOfBs;
				String second = countOfBs == 0 ? "" : value.substring(bIndex, bSize + bIndex);
				
				String candidate = formStringFromPattern(pattern, first, second);
				
				if (candidate.equals(value)) {
					System.out.println(first + ", " + second);
					return true;
				}
			}
		}
		return false;	
	}
	
	public static void main(String[] args) {
		String[][] tests = {{"ababb", "backbatbackbatbat"}, {"abab", "backsbatbackbats"}, {"aba", "backsbatbacksbat"}};
		for (String[] test : tests) {
			String pattern = test[0];
			String value = test[1];
			System.out.println(pattern + ", " + value + ": " + doesMatch(pattern, value));
		}

	}

}
