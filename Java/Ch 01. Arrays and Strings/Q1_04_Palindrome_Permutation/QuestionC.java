package Q1_04_Palindrome_Permutation;

import java.util.BitSet;

import static java.lang.Character.isLetter;

public class QuestionC {
	/* For each letter with value i, toggle the ith bit. */
	public static BitSet createBitSet(String phrase) {
		BitSet checker = new BitSet();
		for (int c : phrase.toLowerCase().toCharArray()) {
			if (isLetter(c))
				checker.flip(c);
		}
		return checker;
	}

	public static boolean isPermutationOfPalindrome(String phrase) {
		return createBitSet(phrase).cardinality() < 2;
	}
	
	public static void main(String[] args) {
		String pali = "Rats live on no evil star";
		System.out.println(isPermutationOfPalindrome(pali));
	}
}
