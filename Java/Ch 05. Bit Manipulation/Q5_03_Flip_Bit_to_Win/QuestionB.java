package Q5_03_Flip_Bit_to_Win;

import java.util.ArrayList;

public class QuestionB {
	
	public static int longestSequence(int n) {
		if (n == -1) return Integer.BYTES * 8;
		ArrayList<Integer> sequences = getAlternatingSequences(n);
		return findLongestSequence(sequences);
	}	
	
	/* Return a list of the sizes of the sequences. The sequence starts 
	 * off with the number of 0s (which might be 0) and then alternates
	 * with the counts of each value.*/
	public static ArrayList<Integer> getAlternatingSequences(int n) {
		ArrayList<Integer> sequences = new ArrayList<Integer>();
		
		int searchingFor = 0;
		int counter = 0;
		
		for (int i = 0; i < Integer.BYTES * 8; i++) {
			if ((n & 1) != searchingFor) {
				sequences.add(counter);
				searchingFor = n & 1; // Flip 1 to 0 or 0 to 1
				counter = 0;	
			}
			counter++;
			n >>>= 1;
		}
		sequences.add(counter);
		
		return sequences;
	}
	
	public static int findLongestSequence(ArrayList<Integer> seq) {
		int maxSeq = 1;
		
		for (int i = 0; i < seq.size(); i += 2) {
			int zerosSeq = seq.get(i);
			int onesSeqPrev = i - 1 >= 0 ? seq.get(i - 1) : 0;
			int onesSeqNext = i + 1 < seq.size() ? seq.get(i + 1) : 0;
			
			int thisSeq = 0;
			if (zerosSeq == 1) { // Can merge
				thisSeq = onesSeqNext + 1 + onesSeqPrev; 
			} else if (zerosSeq > 1) { // Just add a one to either side
				thisSeq = 1 + Math.max(onesSeqPrev, onesSeqNext);
			} else if (zerosSeq == 0) { // No zero, but take either side
				thisSeq = Math.max(onesSeqPrev, onesSeqNext);
			}
			maxSeq = Math.max(thisSeq, maxSeq);
		}
		
		return maxSeq;
	}	
	
	public static void main(String[] args) {
		int original_number = 1775;
		int new_number = longestSequence(original_number);
			
		System.out.println(Integer.toBinaryString(original_number));
		System.out.println(new_number);
	}

}
