package Q1_04_Palindrome_Permutation;

public class QuestionC_ {
	/* Toggle the ith bit in the integer. */
	public static int toggle(int bitVector, int index) {
		if (index < 0) return bitVector;
		
		int mask = 1 << index;
		if ((bitVector & mask) == 0) {
			bitVector |= mask;
		} else {
			bitVector &= ~mask; // 010 & ~(010) = 010 & 101 = 0 => clear a bit by take & of inverted bit vector
		}
		return bitVector;
	}
	
	/* Create bit vector for string. For each letter with value i,
	 * toggle the ith bit. */
	public static int createBitVector(String phrase) {
		// int has 4 bytes or 32 bits; there are 26 letters in the alphabet, a need for 26 slots => satisfied with int!
		int bitVector = 0;
		for (char c: phrase.toCharArray()) {
			int index = Common.getCharNumber(c);
			if (index != -1) {
				int mask = 1 << index;
				bitVector ^= mask; // toggle a bit with XOR here
			}
		}
		return bitVector;
	}
	
	/* Check that at most one bit is set by subtracting one from the 
	 * integer and ANDing it with the original integer. */
	public static boolean checkAtMostOneBitSet(int bitVector) {
		return ((bitVector & (bitVector - 1)) == 0);
	}
	
	public static boolean isPermutationOfPalindrome(String phrase) {
		int bitVector = createBitVector(phrase);
		return checkAtMostOneBitSet(bitVector);
	}
	
	public static void main(String[] args) {
		String pali = "Rats live on no evil star";
		System.out.println(isPermutationOfPalindrome(pali));
		String pali2 = "Rats live on no evil star here";
		System.out.println(isPermutationOfPalindrome(pali2));
	}
}
