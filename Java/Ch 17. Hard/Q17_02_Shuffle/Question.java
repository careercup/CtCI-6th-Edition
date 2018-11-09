package Q17_02_Shuffle;

import java.util.Random;

import CtCILibrary.AssortedMethods;

public class Question {	
	public static int[] shuffleArrayRecursively(int[] cards, int i) {
		if (i == 0) {
			return cards;
		}
		
		/* shuffle elements 0 through index - 1 */
		shuffleArrayRecursively(cards, i - 1);
		Random rand = new Random();
		int k = rand.nextInt(i + 1); // Generate random between 0 and i (inclusive)		
		
		/* Swap element k and index */
		int temp = cards[k];
		cards[k] = cards[i];
		cards[i] = temp;
		
		/* Return shuffled array */
		return cards;
 	}
	
	public static void shuffleArrayIteratively(int[] cards) { 
		Random rand = new Random();
		for (int i = 0; i < cards.length; i++) { 
			int k = rand.nextInt(i + 1); // Generate random between 0 and i (inclusive)
			int temp = cards[k];
			cards[k] = cards[i];
			cards[i] = temp;
		} 
	}
	
	public static void main(String[] args) {
		int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(AssortedMethods.arrayToString(cards));
		shuffleArrayIteratively(cards);
		System.out.println(AssortedMethods.arrayToString(cards));
	}
}
