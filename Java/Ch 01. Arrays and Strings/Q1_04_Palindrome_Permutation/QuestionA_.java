package Q1_04_Palindrome_Permutation;

public class QuestionA_ {
	public static boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for (int i = 0; i < table.length; i++) {
			if (table[i] % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}
	
	public static boolean isPermutationOfPalindrome(String phrase) {
		int[] table = Common_.buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}
	
	public static void main(String[] args) {
		String pali = "Rats live on no evil star";
		System.out.println(isPermutationOfPalindrome(pali));
	}


}
