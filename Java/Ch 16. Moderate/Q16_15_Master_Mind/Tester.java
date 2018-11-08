package Q16_15_Master_Mind;

import java.util.Random;

public class Tester {

	public static Result estimateBad(String g, String s) {
		char[] guess = g.toCharArray();
		char[] solution = s.toCharArray();
		int hits = 0;
		for (int i = 0; i < guess.length; i++) {
			if (guess[i] == solution[i]) {
				hits++;
				solution[i] = '0';
				guess[i] = '0';
			}
		}
		
		int pseudohits = 0;
		
		for (int i = 0; i < guess.length; i++) {
			if (guess[i] != '0') {
				for (int j = 0; j < solution.length; j++) {
					if (solution[j] != '0') {
						if (solution[j] == guess[i]) {
							pseudohits++;
							solution[j] = '0';
							break;
						}
					}
				}
			}
		}
		
		return new Result(hits, pseudohits);
	}
	
	public static String randomString() {
		int length = 4;
		char[] str = new char[length];
		Random generator = new Random();
		
		for (int i = 0; i < length; i++) {
			int v = generator.nextInt(4);
			char c = Question.letterFromCode(v);
			str[i] = c;
		}
		
		return String.valueOf(str);
	}
	
	public static boolean test(String guess, String solution) {
		Result res1 = Question.estimate(guess, solution);
		Result res2 = estimateBad(guess, solution);
		if (res1.hits == res2.hits && res1.pseudoHits == res2.pseudoHits) {
			return true;
		} else {
			System.out.println("FAIL: (" + guess + ", " + solution + "): " + res1.toString() + " | " + res2.toString());
			return false;
		}
	}
	
	public static boolean testRandom() {
		String guess = randomString();
		String solution = randomString();
		return test(guess, solution);
	}
	
	public static boolean test(int count) {
		for (int i = 0; i < count; i++) {
			if (!testRandom()) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		test(1000);
	}
}
