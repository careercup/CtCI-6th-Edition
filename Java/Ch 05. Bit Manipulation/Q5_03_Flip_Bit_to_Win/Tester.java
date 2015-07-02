package Q5_03_Flip_Bit_to_Win;

public class Tester {
	
	public static void main(String[] args) {
		int start = Integer.MAX_VALUE - 1000;
		int range = 2000;
		for (int i = 0; i < range; i++) {
			int value = start + i;
			int seqA = QuestionA.longestSequence(value);
			int seqB = QuestionB.longestSequence(value);
			int seqC = QuestionC.longestSequence(value);
			
			if (seqA != seqB || seqB != seqC) {
				System.out.println("FAILURE on value " + value);
				String xs = Integer.toBinaryString(value);
				System.out.println(xs);
				System.out.println("A: " + seqA);
				System.out.println("B: " + seqB);
				System.out.println("C: " + seqC);
				break;
			} 
		}
	}

}
