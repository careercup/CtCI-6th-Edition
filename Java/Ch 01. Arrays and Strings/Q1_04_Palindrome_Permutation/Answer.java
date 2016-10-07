
import java.util.Arrays;

public class Answer {
	public static boolean isPermutationOfPalindrome(String str){
		str = str.toLowerCase();
		boolean[] check = new boolean[26];
		Arrays.fill(check, false);
		for(int i = 0; i < str.length(); i++){
			int var = str.charAt(i) - 'a';
			if (var >= 0 && var < 26)	check[var] = !check[var];
		}
		int numOfOdd = 0;
		for(int i = 0; i < 26; i++){
			if(check[i] == true)	numOfOdd++;
			if(numOfOdd >= 2)	return false;
		}
		return true;
	}

	public static void main(String[] args){
		String[] strings = {"Rats live on no evil star",
							"A man, a plan, a canal, panama",
							"Lleve",
							"Tacotac",
							"asda"};
		for (String s : strings) {
			boolean result = isPermutationOfPalindrome(s);
			System.out.println(s);
			System.out.println(result);
		}

	}


}