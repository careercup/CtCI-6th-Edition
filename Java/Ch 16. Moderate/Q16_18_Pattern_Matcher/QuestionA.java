package Q16_18_Pattern_Matcher;

public class QuestionA {


	public static boolean doesMatch(String pattern, String value) {
		if (pattern.length() == 0) return value.length() == 0;
		int size = value.length();
		
		for (int mainSize = 0; mainSize <= size; mainSize++) {
			String main = value.substring(0, mainSize);
			for (int altStart = mainSize; altStart <= size; altStart++) {
				for (int altEnd = altStart; altEnd <= size; altEnd++) {
					String alt = value.substring(altStart, altEnd);
					String cand = buildFromPattern(pattern, main, alt);
					if (cand.equals(value)) {
						System.out.println(main + ", " + alt);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static String buildFromPattern(String pattern, String main, String alt) {	
		StringBuffer sb = new StringBuffer();
		char first = pattern.charAt(0);
		for (char c : pattern.toCharArray()) {
			if (c == first) {
				sb.append(main);
			} else {
				sb.append(alt);
			}
		}
		return sb.toString();
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
