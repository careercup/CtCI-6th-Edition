package Q17_08_Circus_Tower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionOld {

	// Returns longer sequence
	private static List<HtWt> seqWithMaxLength(List<HtWt> seq1, List<HtWt> seq2) {
		if (seq1 == null) {
			return seq2;
		} else if (seq2 == null) {
			return seq1;
		}
		return seq1.size() > seq2.size() ? seq1 : seq2;
	}

	private static void longestIncreasingSubsequence(List<HtWt> array, List<List<HtWt>> solutions, int current_index) {
		if (current_index >= array.size() || current_index < 0) {
			return;
		}
		HtWt current_element = array.get(current_index);
		
		// Find longest sequence that we can append current_element to
		List<HtWt> best_sequence = null;
		for (int i = 0; i < current_index; i++) {
			if (array.get(i).isBefore(current_element)) { // If current_element is bigger than list tail
				best_sequence = seqWithMaxLength(best_sequence, solutions.get(i)); // Set best_sequence to our new max
			}
		}
		
		// Append current_element
		List<HtWt> new_solution = new ArrayList<>();
		if (best_sequence != null) {
			new_solution.addAll(best_sequence);
		} 
		new_solution.add(current_element);
		
		// Add to list and recurse
		solutions.add(current_index, new_solution);
		longestIncreasingSubsequence(array, solutions, current_index + 1);
	}

	public static List<HtWt> longestIncreasingSeq(List<HtWt> array) {
		Collections.sort(array);

		List<List<HtWt>> solutions = new ArrayList<>();
		longestIncreasingSubsequence(array, solutions, 0);

		List<HtWt> best_sequence = null;
		for (int i = 0; i < array.size(); i++) {
			best_sequence = seqWithMaxLength(best_sequence, solutions.get(i));
		}
		
		return best_sequence;
	}

	public static List<HtWt> initialize() {
		List<HtWt> items = new ArrayList<>();
		
		HtWt item = new HtWt(65, 60);
		items.add(item);
		
		item = new HtWt(70, 150);
		items.add(item);
		
		item = new HtWt(56, 90);
		items.add(item);
		
		item = new HtWt(75, 190);
		items.add(item);
		
		item = new HtWt(60, 95);
		items.add(item);
		
		item = new HtWt(68, 110);
		items.add(item);
		
		item = new HtWt(35, 65);
		items.add(item);
		
		item = new HtWt(40, 60);
		items.add(item);
		
		item = new HtWt(45, 63);
		items.add(item);
		
		return items;
	}

	public static void printList(List<HtWt> list) {
		for (HtWt item : list) {
			System.out.println(item + " ");
		}
	}
	
	public static void main(String[] args) {
		List<HtWt> items = initialize();
		List<HtWt> solution = longestIncreasingSeq(items);
		printList(solution);
	}

}
