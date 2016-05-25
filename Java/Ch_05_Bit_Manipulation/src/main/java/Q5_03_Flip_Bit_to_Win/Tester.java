package Q5_03_Flip_Bit_to_Win;

public class Tester {
	
	public static boolean checkRange(int start, int range) {
		for (int i = 0; i < range; i++) {
			int value = start + i;
			int seqA = QuestionA.longestSequence(value);
			int seqB = QuestionB.longestSequence(value);
			int seqC = QuestionC.longestSequence(value);
			int seqD = QuestionC.longestSequence(value);
			
			if (seqA != seqB || seqB != seqC || seqC != seqD) {
				System.out.println("FAILURE on value " + value);
				String xs = Integer.toBinaryString(value);
				System.out.println(xs);
				System.out.println("A: " + seqA);
				System.out.println("B: " + seqB);
				System.out.println("C: " + seqC);
				System.out.println("D: " + seqD);
				return false;
			} 
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] ranges = {{Integer.MIN_VALUE, 1000}, {Integer.MAX_VALUE - 2333, 5333},
				{-10000, 20000}};
		for (int[] range : ranges) {
			if (!checkRange(range[0], range[1])) {
				System.out.println("ERROR");
			} else {
				int end = range[0] + range[1];
				System.out.println("SUCCESS: " + range[0] + " -> " + end);
			}
		}
	}

}
