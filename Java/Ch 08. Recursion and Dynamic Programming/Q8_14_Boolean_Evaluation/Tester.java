package Q8_14_Boolean_Evaluation;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

public class Tester {
	
	public static boolean allEqual(HashMap<String, Integer> map) {
		int val = 0;
		for (Entry<String, Integer> e : map.entrySet()) {
			if (val != 0 && val != e.getValue()) {
				return false;
			}
			val = e.getValue();
		}
		return true;
	}
	
	public static char getRandomOperator() {
		Random rand = new Random();
		int r = rand.nextInt(3);
		char[] ops = {'^', '&', '|'};
		return ops[r];
	}
	
	public static String getRandomExpression() {
		Random rand = new Random();
		int len = rand.nextInt(10) * 2 + 1;
		String s = "";
		for (int i = 0; i < len; i++) {
			char next = '1';
			if (i % 2 == 0) {
				next = rand.nextBoolean() ? '1' : '0';
			} else {
				next = getRandomOperator();
			}
			s += next;
		}
		return s;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			//String terms = "0^0|1&1^1|0|1";
			String terms = getRandomExpression();
			boolean result = true;
			
			int oBF = Others.bruteForce(terms, new HashMap<String, Boolean>(), result, new boolean[(terms.length() - 1) / 2]);
			int oR = Others.countR(terms, result, 0, terms.length() - 1);
			int oDP = Others.countDP(terms, result, 0, terms.length() - 1, new HashMap<String, Integer>());
			int oDPEFF = Others.countDPEff(terms, result, 0, terms.length() - 1, new HashMap<String, Integer>());
			
			int a = QuestionA.countEval(terms, result);
			int b = QuestionB.countEval(terms, result);
			
			HashMap<String, Integer> results = new HashMap<String, Integer>();
			results.put("oBF", oBF);
			results.put("oR", oR);
			results.put("oDP", oDP);
			results.put("oDPEFF", oDPEFF);
			results.put("a", a);
			results.put("b", b);
			
			if (allEqual(results)) {
				System.out.println("Success: " + terms + "->" + b);
				System.out.println(results.toString());
			} else {
				System.out.println("Failure: " + terms);
				System.out.println(results.toString());
				break;
			}
		}
		
	}

}
