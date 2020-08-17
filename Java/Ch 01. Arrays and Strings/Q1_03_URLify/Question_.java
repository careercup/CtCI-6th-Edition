package Q1_03_URLify;

import CtCILibrary.AssortedMethods;

public class Question_ {
	// Assume string has sufficient free space at the end
	public static void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0;
		for (int i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		int writeIndex = trueLength + spaceCount * 2;
		for (int readIdx = trueLength - 1; readIdx >= 0; readIdx--) {
			if (str[readIdx] == ' ') {
				str[--writeIndex] = '0';
				str[--writeIndex] = '2';
				str[--writeIndex] = '%';
			} else {
				str[--writeIndex] = str[readIdx];
			}
		}
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
		String str = "Mr John Smith    ";
		char[] arr = str.toCharArray();
		int trueLength = findLastCharacter(arr) + 1;
		replaceSpaces(arr, trueLength);	
		System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
	}
}
