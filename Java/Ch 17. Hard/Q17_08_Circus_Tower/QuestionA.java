package Q17_08_Circus_Tower;

import java.util.ArrayList;
import java.util.*;

public class QuestionA {
	public static ArrayList<HtWt> longestIncreasingSeq(ArrayList<HtWt> items) {
		Collections.sort(items);
		return bestSeqAtIndex(items, new ArrayList<HtWt>(), 0);
	}
	
	// Returns longer sequence
	private static ArrayList<HtWt> max(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
		if (seq1 == null) {
			return seq2;
		} else if (seq2 == null) {
			return seq1;
		}
		return seq1.size() > seq2.size() ? seq1 : seq2;
	}
	
	private static boolean canAppend(ArrayList<HtWt> solution, HtWt value) {
		if (solution == null) {
			return false;
		}
		if (solution.size() == 0) {
			return true;
		}
		HtWt last = solution.get(solution.size() - 1);
		return last.isBefore(value);
	}
	
	private static ArrayList<HtWt> bestSeqAtIndex(ArrayList<HtWt> array, ArrayList<HtWt> sequence, int index) {
		if (index >= array.size()) return sequence;
		
		HtWt value = array.get(index);
		
		ArrayList<HtWt> bestWith = null;
		if (canAppend(sequence, value)) {
			ArrayList<HtWt> sequenceWith = (ArrayList<HtWt>) sequence.clone();
			sequenceWith.add(value);
			bestWith = bestSeqAtIndex(array, sequenceWith, index + 1);
		}
		
		ArrayList<HtWt> bestWithout = bestSeqAtIndex(array, sequence, index + 1);
		return max(bestWith, bestWithout);
	}
	
	public static ArrayList<HtWt> initialize() {
		ArrayList<HtWt> items = new ArrayList<HtWt>();
		
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
	
	public static void printList(ArrayList<HtWt> list) {
		for (HtWt item : list) {
			System.out.println(item.toString() + " ");
		}
	}
	
	
	public static void main(String[] args) {
		ArrayList<HtWt> items = initialize();
		ArrayList<HtWt> solution = longestIncreasingSeq(items);
		printList(solution);
	}

}
