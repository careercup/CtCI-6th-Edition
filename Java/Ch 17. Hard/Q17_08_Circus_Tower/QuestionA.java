package Q17_08_Circus_Tower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionA {
	public static List<HtWt> longestIncreasingSeq(List<HtWt> items) {
		Collections.sort(items);
		return bestSeqAtIndex(items, new ArrayList<HtWt>(), 0);
	}
	
	// Returns longer sequence
	private static List<HtWt> max(List<HtWt> seq1, List<HtWt> seq2) {
		if (seq1 == null) {
			return seq2;
		} else if (seq2 == null) {
			return seq1;
		}
		return seq1.size() > seq2.size() ? seq1 : seq2;
	}

	private static boolean canAppend(List<HtWt> solution, HtWt value) {
		if (solution == null) {
			return false;
		}
		if (solution.size() == 0) {
			return true;
		}
		HtWt last = solution.get(solution.size() - 1);
		return last.isBefore(value);
	}

	private static List<HtWt> bestSeqAtIndex(List<HtWt> array, List<HtWt> sequence, int index) {
		if (index >= array.size()) return sequence;
		
		HtWt value = array.get(index);

		List<HtWt> bestWith = null;
		if (canAppend(sequence, value)) {
			List<HtWt> sequenceWith = new ArrayList<>(sequence);
			sequenceWith.add(value);
			bestWith = bestSeqAtIndex(array, sequenceWith, index + 1);
		}

		List<HtWt> bestWithout = bestSeqAtIndex(array, sequence, index + 1);
		
		if (bestWith == null || bestWithout.size() > bestWith.size()) {
			return bestWithout;
		} else {
			return bestWith;
		}
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
