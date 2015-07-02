package Q8_14_Boolean_Evaluation;

public class QuestionC {
	public static int count = 0;
	public static boolean stringToBool(String c) {
		return c.equals("1") ? true : false;
	}
	
	public static int countEval(String s, boolean result) {
		count++;
		if (s.length() == 0) return 0;
		if (s.length() == 1) return stringToBool(s) == result ? 1 : 0;

		int ways = 0;
		
		for (int i = 1; i < s.length(); i += 2) {
			char c = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i + 1, s.length());
			
			int subWays = 0;
			if (c == '^') { // required: one true and one false
				if (result) {
					int leftTrue = countEval(left, true);
					int leftFalse = countEval(left, false);
					int rightTrue = countEval(right, true);
					int rightFalse = countEval(right, false);
					subWays = leftTrue * rightFalse + leftFalse * rightTrue;
				} else {
					int leftTrue = countEval(left, true);
					int leftFalse = countEval(left, false);
					int rightTrue = countEval(right, true);
					int rightFalse = countEval(right, false);
					subWays = leftTrue * rightTrue + leftFalse * rightFalse;				
				}
			} else if (c == '&') { // required: both true
				if (result) {
					int leftTrue = countEval(left, true);
					int rightTrue = countEval(right, true);
					subWays = leftTrue * rightTrue;
				} else {
					int leftTrue = countEval(left, true);
					int leftFalse = countEval(left, false);
					int rightTrue = countEval(right, true);
					int rightFalse = countEval(right, false);
					subWays = leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;				
				}				
			} else if (c == '|') { // required: anything but both false
				if (result) {
					int leftTrue = countEval(left, true);
					int leftFalse = countEval(left, false);
					int rightTrue = countEval(right, true);
					int rightFalse = countEval(right, false);
					subWays = leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
				} else {
					int leftFalse = countEval(left, false);
					int rightFalse = countEval(right, false);
					subWays = leftFalse * rightFalse;				
				}
			}
			ways += subWays;
		}
		
		return ways;
	}
	
	public static void main(String[] args) {		
		String expression = "0&0&0&1^1|0";
		boolean result = true;
		
		System.out.println(countEval(expression, result));
		System.out.println(count);
	}

}
