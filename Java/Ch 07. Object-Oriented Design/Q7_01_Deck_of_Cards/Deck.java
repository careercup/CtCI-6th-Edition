package Q7_01_Deck_of_Cards;

import CtCILibrary.AssortedMethods;

import java.util.List;

public class Deck <T extends Card> {
	private List<T> cards;
	private int dealtIndex = 0; // marks first undealt card

	public void setDeckOfCards(List<T> deckOfCards) {
		cards = deckOfCards;
	}
	
	public void shuffle() {
		for (int i = 0; i < cards.size(); i++) {
			int j = AssortedMethods.randomIntInRange(i, cards.size() - i - 1);
			T card1 = cards.get(i);
			T card2 = cards.get(j);
			cards.set(i, card2);
			cards.set(j, card1);
		}
	}
	
	public int remainingCards() {
		return cards.size() - dealtIndex;
	}
	
	public T[] dealHand(int number) {
		if (remainingCards() < number) {
			return null;
		}
		
		T[] hand = (T[]) new Card[number];
		int count = 0;
		while (count < number) {
			T card = dealCard();
			if (card != null) {
				hand[count] = card;
				count++;
			}
		}
		
		return hand;
	}
	
	public T dealCard() {
		if (remainingCards() == 0) {
			return null;
		}
		
		T card = cards.get(dealtIndex);
		card.markUnavailable();
		dealtIndex++;
		
		return card;		
	}
	
	public void print() {
		for (Card card : cards) {
			card.print();
		}
	}
}
