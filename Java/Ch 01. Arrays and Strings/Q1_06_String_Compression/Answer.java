public class Answer {
	public static String compression(String str) {
		str = str.toLowerCase();
		boolean ifLessThan = lengthComparison(str);
		if (ifLessThan == false) {
			return str;
		}
		StringBuilder output = new StringBuilder(str.length());
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			counter++;
			if (i == str.length() - 1 || str.charAt(i) != str.charAt(i+1)){
				output.append(str.charAt(i));
				output.append(counter);
				counter = 0;					
			}
			if (output.length() > str.length())	return str;
		}
		return output.toString();
	}

	public static boolean lengthComparison(String str) {
		int lengthCompression = 0;
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			counter++;
			if (i == str.length() - 1 || str.charAt(i) != str.charAt(i+1)) {
				lengthCompression += 1 + (int) Math.log10(counter) + 1;
				counter = 0;
			}
		}
		if (lengthCompression <= str.length()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String[] tests = {
			"aaaaaaaaaaaaaaaaabbbbbc",
			"aaabcccccaaa", 
			"bbbaababbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb",
			"a",
			"aaaaabbbbaaaabbddc",
			"",
			"aabbcc"
		};
		for (int i = 0; i < tests.length; i++) {
			String test = tests[i];
			System.out.println(compression(test));
		}
	}
}