public class Answer {
	public static boolean ifOneAway(String str1, String str2) {
		int type = Math.abs(str1.length() - str2.length());
		if (type == 0 || type == 1) {
			boolean firstBigger = str1.length() > str2.length();
			boolean foundDifference = false;
			for(int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
				if (!foundDifference && str1.charAt(i) != str2.charAt(i)) {
					foundDifference = true;
					if (type == 0){
						continue;
					}
				}
				if (foundDifference && str1.charAt(i + (firstBigger ? type : 0)) != str2.charAt(i + (!firstBigger ? type : 0)))	return false;
			}
			return true;
		} else	return false;
	}

	public static void main(String[] args) {
		String[][] tests = {{"a", "b", "true"}, 
				{"", "d", "true"},
				{"d", "de", "true"},
				{"pale", "pse", "false"},
				{"acdsfdsfadsf", "acdsgdsfadsf", "true"},
				{"acdsfdsfadsf", "acdsfdfadsf", "true"},
				{"acdsfdsfadsf", "acdsfdsfads", "true"},
				{"acdsfdsfadsf", "cdsfdsfadsf", "true"},
				{"adfdsfadsf", "acdfdsfdsf", "false"},
				{"adfdsfadsf", "bdfdsfadsg", "false"},
				{"adfdsfadsf", "affdsfads", "false"},
				{"pale", "pkle", "true"},
				{"pkle", "pable", "false"}};
		for (int i = 0; i < tests.length; i++) {
			String[] test = tests[i];
			String a = test[0];
			String b = test[1];
			System.out.println(ifOneAway(a, b) + test[2]);

		}
		
	}
}