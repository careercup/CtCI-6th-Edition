package Q17_02_Shuffle;

import CtCILibrary.AssortedMethods;

public class Question {

	/* Random number between lower and higher, inclusive */
	public static int rand(int lower, int higher) { 
		return lower + (int)(Math.random() * (higher - lower + 1));
	}	
	
	public static void shuffleArrayRecursively(int[] cards, int i) {
		if (i == 1) {
			return;
		}
		
		/* shuffle element at index (i - 1) with a random element 0 through i - 1 */
		int k = rand(0, --i);		
		
		/* Swap element k and index */
		int temp = cards[k];
		cards[k] = cards[i];
		cards[i] = temp;
		
		shuffleArrayRecursively(cards, i);
	}

	public static void shuffleArrayIteratively(int[] cards) { 
		for (int i = cards.length - 1 ; i > 0; i--) {
			int k = rand(0, i);
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
