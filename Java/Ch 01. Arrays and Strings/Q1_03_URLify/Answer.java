public class Answer{
	public static char[] urlify(char[] str, int trueLength) {
		int spaceNumm = 0;
		for(int i = 0; i < trueLength; i++) {
			if (str[i] == ' ') spaceNumm++;
		}
		for(int i = trueLength - 1; i >= 0; i--) {
			if (str[i] != ' ' || spaceNumm == 0) str[i + spaceNumm * 2] = str[i];
			else{
				str[i + spaceNumm * 2] = '0';
				str[i + spaceNumm * 2 - 1] = '2';
				str[i + spaceNumm * 2 - 2] = '%';
				spaceNumm--;
			}
		}
		return str;
	}

	public static int findLastCharacter(char[] str) {
		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String str = "Mr   John  Smith          ";
		char[] arr = str.toCharArray();
		int trueLength = findLastCharacter(arr) + 1;
		urlify(arr, trueLength);	
		System.out.println(java.util.Arrays.toString(arr));
	}
}