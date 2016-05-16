package Q16_18_Pattern_Matcher;

public class Tester {
	public static String invert(String pattern) {
		String inverted = "";
		for (char c : pattern.toCharArray()) {
			if (c == 'a') {
				inverted += 'b';
			} else if (c == 'b') {
				inverted += 'a';
			}
		}
		return inverted;
	}
	
	public static void main(String[] args) {
		String[][] tests = {{"ababb", "backbatbackbatbat"}, {"ababaa", "batgobatgobatbat"}, {"bb", "backback"}, {"ababb", "backbatbackbatbat"}, {"ababb", "backbatbackbatbackbat"}, {"abab", "backsbatbackbats"}, {"aba", "backsbatbacksbat"}};
		for (String[] test : tests) {
			for (int i = 0; i <= 1; i++) {
				String pattern = i == 0 ? test[0] : invert(test[0]);
				String value = test[1];
				boolean aMatches = QuestionA.doesMatch(pattern, value);
				boolean bMatches = QuestionB.doesMatch(pattern, value);
				boolean cMatches = QuestionC.doesMatch(pattern, value);
				boolean dMatches = QuestionD.doesMatch(pattern, value);
				if (aMatches != bMatches || aMatches != cMatches || aMatches != dMatches) {
					System.out.println("ERROR");
				}
				System.out.println(pattern + ", " + value + ": " + aMatches);
				System.out.println(pattern + ", " + value + ": " + bMatches);
				System.out.println(pattern + ", " + value + ": " + cMatches);
				System.out.println(pattern + ", " + value + ": " + dMatches);
			}
		}

	}

}
