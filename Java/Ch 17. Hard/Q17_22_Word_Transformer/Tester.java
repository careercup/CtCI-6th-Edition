package Q17_22_Word_Transformer;

import java.util.Deque;

public class Tester {

	public static void printList(Deque<String> list) {
		if (list == null) {
			System.out.println("No path.");
		} else {
			System.out.println(list.toString());
		}
	}
	
	public static void main(String[] args) {
		String[] words = {"maps", "tan", "tree", "apple", "cans", "help", "aped", "pree", "pret", "apes", "flat", "trap", "fret", "trip", "trie", "frat", "fril"};
		Deque<String> listA = QuestionA.transform("tree", "flat", words);
		Deque<String> listB = QuestionB.transform("tree", "flat", words);
		Deque<String> listC = QuestionC.transform("tree", "flat", words);
		printList(listA);
		printList(listB);
		printList(listC);
	}

}
