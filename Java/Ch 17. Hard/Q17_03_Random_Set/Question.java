package Q17_03_Random_Set;

import java.util.Random;
import java.util.Arrays;

import CtCILibrary.AssortedMethods;

public class Question {
        /* Pick M elements from original array.  Clone original array so that
	 * we don't destroy the input. */
	public static int[] pickMRandomly(int[] original, int m) {
		int[] clone = original;
                Random rand = new Random();
		for (int i = 0; i < clone.length; i++) { 
			int k = rand.nextInt(i + 1); // Generate random between 0 and i (inclusive)
			int temp = clone[k];
			clone[k] = clone[i];
			clone[i] = temp;
		} 
                int[] subClone = Arrays.copyOfRange(clone, 0, m + 1);
		return subClone; 
	}
	
	public static void main(String[] args) {
		int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(AssortedMethods.arrayToString(cards));
		int[] set = pickMRandomly(cards, 4);
		System.out.println(AssortedMethods.arrayToString(set));
	}

}
