package Q17_08_Circus_Tower;

import java.util.ArrayList;
import java.util.List;

public class Tester {
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static boolean validate(List<HtWt> seq) {
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
			List<HtWt> arrayA = new ArrayList<>();
			List<HtWt> arrayB = new ArrayList<>();
			List<HtWt> arrayC = new ArrayList<>();
			for (int i = 0; i < 10; i++)  {
				HtWt value = new HtWt(randomInt(100), randomInt(100));
				arrayA.add(value);
				arrayB.add(value);
				arrayC.add(value);
			}

			List<HtWt> seq1 = QuestionA.longestIncreasingSeq(arrayA);
			List<HtWt> seq2 = QuestionB.longestIncreasingSeq(arrayB);
			List<HtWt> seq3 = QuestionOld.longestIncreasingSeq(arrayC);
			
			if (seq1.size() != seq2.size() || seq1.size() != seq3.size()) {
				System.out.println("ERROR: " + seq1.size() + ", " + seq2.size() + ", " + seq3.size());
				System.out.println(seq1);
				System.out.println(seq2);
				break;
			} else {
				System.out.println("SUCCESS: " + seq1.size() + " == " + seq2.size() + " == " + seq3.size());
				System.out.println(seq1);
				System.out.println(seq2);
				System.out.println(seq3);
			}
		}
	}

}
