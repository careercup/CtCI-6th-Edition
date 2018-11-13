package Q17_02_Shuffle;

import java.util.Random;

import CtCILibrary.AssortedMethods;

public class Question {	
	public static int[] shuffleArrayRecursively(int[] cards, int i) {
		if (i == 0) {
			return;
		}
		
		/* shuffle element at index (i - 1) with a random element 0 through i - 1 */
		Random rand = new Random();
		int k = rand.nextInt(i); // Generate random between 0 and i - 1 (inclusive)		
		
		/* Swap element k and index */
		int temp = cards[k];
		cards[k] = cards[i];
		cards[i] = temp;
		
		shuffleArrayRecursively(cards, --i);
	}

	public static void shuffleArrayIteratively(int[] cards) { 
		Random rand = new Random();
		for (int i = cards.length - 1 ; i > 0; i--) { 
			int k = rand.nextInt(i + 1); // Generate random between 0 and i (inclusive)
			int temp = cards[k];
			cards[k] = cards[i];
			cards[i] = temp;
		} 
	}
	
	public static void main(String[] args) {
		int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(AssortedMethods.arrayToString(cards));
		shuffleArrayRecursively(cards, cards.length);
		System.out.println(AssortedMethods.arrayToString(cards));
		shuffleArrayIteratively(cards);
		System.out.println(AssortedMethods.arrayToString(cards));
	}
}
