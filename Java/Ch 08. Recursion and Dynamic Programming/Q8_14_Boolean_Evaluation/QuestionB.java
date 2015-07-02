package Q8_14_Boolean_Evaluation;

import java.util.HashMap;

public class QuestionB {
	
	public static int count = 0;
	public static boolean stringToBool(String c) {
		return c.equals("1") ? true : false;
	}
	
	public static int countEval(String s, boolean result, HashMap<String, Integer> memo) {
		count++;
		if (s.length() == 0) return 0;
		if (s.length() == 1) return stringToBool(s) == result ? 1 : 0;
		if (memo.containsKey(result + s)) return memo.get(result + s);

		int ways = 0;
		
		for (int i = 1; i < s.length(); i += 2) {
			char c = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i + 1, s.length());
			int leftTrue = countEval(left, true, memo);
			int leftFalse = countEval(left, false, memo);
			int rightTrue = countEval(right, true, memo);
			int rightFalse = countEval(right, false, memo);
			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
			
			int totalTrue = 0;
			if (c == '^') {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			} else if (c == '&') {
				totalTrue = leftTrue * rightTrue;
			} else if (c == '|') {
				totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
			}
			
			int subWays = result ? totalTrue : total - totalTrue;
			ways += subWays;
		}
		
		memo.put(result + s, ways);
		return ways;
	}
	
	public static int countEval(String s, boolean result) {
		return countEval(s, result, new HashMap<String, Integer>());
	}
	
	public static void main(String[] args) {
		String expression = "0^0|1&1^1|0|1";
		boolean result = true;
		
		System.out.println(countEval(expression, result));
		System.out.println(count);
	}

}
