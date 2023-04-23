package Q5_03_Flip_Bit_to_Win;

public class QuestionC {

	public static int SEQUENCE_LENGTH = 32;
	
	/* Given set of three sequences ordered as {0s, then 1s, then 0s}, 
	 * find max sequence that can be formed. */
	public static int getMaxSequence(int[] sequences) { /* 1s, then 0s, then [old] ones */
		if (sequences[1] == 1) { // a single 0 -> merge sequences
			return sequences[0] + sequences[2] + 1; 
		} else if (sequences[1] == 0) { // no 0s -> take one side
			return Math.max(sequences[0], sequences[2]); 
		} else {  // many 0s -> take side, add 1 (flip a bit)
			return Math.max(sequences[0], sequences[2]) + 1;
		}
	}
	
	public static void shift(int[] sequences) {
		sequences[2] = sequences[1];
		sequences[1] = sequences[0];
		sequences[0] = 0;
	}
	
	public static int longestSequence(int n) {
		int searchingFor = 0;
		int[] sequences = {0, 0, 0}; // Counts of last 3 sequences
		int maxSequence = 1;
		
		for (int i = 0; i < SEQUENCE_LENGTH; i++) {
			if ((n & 1) != searchingFor) {
				if (searchingFor == 1) { // End of 1s + 0s + 1s sequence
					maxSequence = Math.max(maxSequence, getMaxSequence(sequences));
				}
				
				searchingFor = n & 1; // Flip 1 to 0 or 0 to 1
				shift(sequences); // Shift sequences
			}
			sequences[0]++;
			n >>>= 1;
		}
		
		/* Check final set of sequences */
		if (searchingFor == 0) {
			shift(sequences);		
		}
		int finalSequence = getMaxSequence(sequences);
		maxSequence = Math.max(finalSequence, maxSequence);		
		
		return maxSequence;
	}		
	
	public static void main(String[] args) {
		int original_number = Integer.MAX_VALUE;
		int new_number = longestSequence(original_number);
			
		System.out.println(Integer.toBinaryString(original_number));
		System.out.println(new_number);		
	}

}
