package Q1_04_Palindrome_Permutation;

public class QuestionC {

	public static boolean isPermutationOfPalindrome(String phrase) {
		/* Create bit vector for string. For each letter with value i, toggle the ith bit. */
		int bitVector = 0;
		for (char c : phrase.toCharArray()) {
			int index = Common.getCharNumber(c);
			bitVector = (index < 0) ? bitVector : (bitVector ^ (1 << index));
		}

		/* Check that at most one bit is set by subtracting one from the
		 * integer and ANDing it with the original integer. */
		return (bitVector & (bitVector - 1)) == 0;
	}

	public static void main(String[] args) {
		String pali = "Rats live on no evil star";
		System.out.println(isPermutationOfPalindrome(pali));
	}
}
