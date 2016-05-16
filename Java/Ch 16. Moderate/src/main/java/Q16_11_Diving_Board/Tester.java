package Q16_11_Diving_Board;

import java.util.HashSet;

public class Tester {

	public static void main(String[] args) {
		int nSticks = 12;
		int shorter = 2;
		int longer = 3;
		HashSet<Integer> lengthsA = QuestionA.allLengths(nSticks, shorter, longer);
		HashSet<Integer> lengthsB = QuestionB.allLengths(nSticks, shorter, longer);
		HashSet<Integer> lengthsC = QuestionC.allLengths(nSticks, shorter, longer);
		System.out.println(QuestionB.counter);
		
		System.out.println(lengthsA.toString());
		System.out.println(lengthsB.toString());
		System.out.println(lengthsC.toString());
		
		System.out.println(lengthsA.equals(lengthsB) && lengthsA.equals(lengthsC));
		System.out.println("Calls for A: " + QuestionA.counter);
		System.out.println("Calls for B: " + QuestionB.counter);
		System.out.println("Calls for C: " + QuestionC.counter);
	}

}
