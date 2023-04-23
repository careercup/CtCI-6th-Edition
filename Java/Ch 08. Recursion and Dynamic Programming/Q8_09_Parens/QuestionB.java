package Q8_09_Parens;

import java.util.ArrayList;

public class QuestionB {
	
	public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
		if (leftRem < 0 || rightRem < leftRem) return; // invalid state
		
		if (leftRem == 0 && rightRem == 0) { /* all out of left and right parentheses */
			list.add(String.copyValueOf(str));
		} else {
			str[index] = '('; // Add left and recurse
			addParen(list, leftRem - 1, rightRem, str, index + 1);
			
			str[index] = ')'; // Add right and recurse
			addParen(list, leftRem, rightRem - 1, str, index + 1);
		}
	}
	
	public static ArrayList<String> generateParens(int count) {
		char[] str = new char[count*2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, count, count, str, 0);
		return list;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = generateParens(6);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println(list.size());		
	}

}
