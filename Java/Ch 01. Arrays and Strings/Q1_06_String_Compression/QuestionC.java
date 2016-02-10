package Q1_06_String_Compression;

public class QuestionC {	
	public static String compress(String str) {
		int finalLength = countCompression(str);
		if (finalLength >= str.length()) return str;

		StringBuilder compressed = new StringBuilder(finalLength); // initialize capacity
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			/* If next character is different than current, append this char to result.*/
			if (isDifferentFromNext(str, i)) {
				compressed.append(str.charAt(i))
						  .append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();
	}
	public static int countCompression(CharSequence str) {
		int compressedLength = 0;
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;

			/* If next character is different than current, append this char to result.*/
			if (isDifferentFromNext(str, i)) {
				compressedLength += (int) Math.log10(countConsecutive) + 2;
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}

	private static boolean isDifferentFromNext(CharSequence str, int i) {
		return i + 1 >= str.length()
			   || str.charAt(i) != str.charAt(i + 1);
	}

	public static void main(String[] args) {
		String str = "aa";
		System.out.println(str);
		System.out.println(compress(str));
	}
}
