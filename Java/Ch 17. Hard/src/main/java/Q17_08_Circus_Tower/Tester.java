package Q17_08_Circus_Tower;

import java.util.ArrayList;

public class Tester {
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static boolean validate(ArrayList<HtWt> seq) {
		for (int i = 1; i < seq.size(); i++) {
			HtWt prev = seq.get(i - 1);
			HtWt curr = seq.get(i);
			if (!prev.isBefore(curr)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		for (int j = 0; j < 100; j++) {
			ArrayList<HtWt> arrayA = new ArrayList<HtWt>();
			ArrayList<HtWt> arrayB = new ArrayList<HtWt>();
			ArrayList<HtWt> arrayC = new ArrayList<HtWt>();
			for (int i = 0; i < 10; i++)  {
				HtWt value = new HtWt(randomInt(100), randomInt(100));
				arrayA.add(value);
				arrayB.add(value);
				arrayC.add(value);
			}
			
			ArrayList<HtWt> seq1 = QuestionA.longestIncreasingSeq(arrayA);
			ArrayList<HtWt> seq2 = QuestionB.longestIncreasingSeq(arrayB);
			ArrayList<HtWt> seq3 = QuestionOld.longestIncreasingSeq(arrayC);
			
			if (seq1.size() != seq2.size() || seq1.size() != seq3.size()) {
				System.out.println("ERROR: " + seq1.size() + ", " + seq2.size() + ", " + seq3.size());
				System.out.println(seq1.toString());
				System.out.println(seq2.toString());
				break;
			} else {
				System.out.println("SUCCESS: " + seq1.size() + " == " + seq2.size() + " == " + seq3.size());
				System.out.println(seq1.toString());
				System.out.println(seq2.toString());	
				System.out.println(seq3.toString());			
			}
		}
	}

}
