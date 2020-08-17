package Q1_04_Palindrome_Permutation;

public class Common_ {

	public static int getCharNumber(Character c) {
		int val_a = Character.getNumericValue('a');
		int val_z = Character.getNumericValue('z');
		int val_c = Character.getNumericValue(c);
		if (val_c >= val_a && val_c <= val_z) {
			return val_c - val_a;
		}
		return -1;
	}
	
	public static int[] buildCharFrequencyTable(String phrase) {
		int size = Character.getNumericValue('z') - Character.getNumericValue('a') + 1;
		int[] result = new int[size];
		for (char c: phrase.toCharArray()) {
			int val_c = getCharNumber(c);
			if (val_c != -1) {
				result[val_c]++;
			}
		}
		return result;
	}

}
