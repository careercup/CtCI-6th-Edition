import java.util.Scanner;
import java.util.Arrays;

public class Answer{
	public static boolean ifPermutation(String str1, String str2){
		if (str1.length() != str2.length()) {
			return false;
		}
		else{
			int[] codec1 = transferToCodec(str1);
			int[] codec2 = transferToCodec(str2);
			return Arrays.equals(codec1, codec2);
		}
		
	}

	public static int[] transferToCodec(String str){
		int[] codec = new int[128];
		for(int i = 0; i < 128; i++)
			codec[i] = 0;
		
		for(int i = 0; i < str.length(); i++){
			int var = str.charAt(i);
			codec[var]++;
		}
		// System.out.println(Arrays.toString(codec));
		return codec;
	}

	public static void main(String[] args){
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = ifPermutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
	}
}