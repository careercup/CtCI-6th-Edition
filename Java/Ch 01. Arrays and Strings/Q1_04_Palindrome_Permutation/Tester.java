package Q1_04_Palindrome_Permutation;

public class Tester {

	
	public static void main(String[] args) {
		String[] strings = {"Rats live on no evil star",
							"A man, a plan, a canal, panama",
							"Lleve",
							"Tacotac",
							"asda"};
		for (String s : strings) {
			boolean a = QuestionA.isPermutationOfPalindrome(s);
			boolean b = QuestionB.isPermutationOfPalindrome(s);
			boolean c = QuestionC.isPermutationOfPalindrome(s);
			System.out.println(s);
			if (a == b && b == c) {
				System.out.println("Agree: " + a);
			} else {
				System.out.println("Disagree: " + a + ", " + b + ", " + c);
			}
			System.out.println();
		}

	}

}
