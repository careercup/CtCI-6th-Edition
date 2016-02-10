package Q8_04_Power_Set;

import java.util.ArrayList;
import java.util.List;

public class QuestionA {

	public static List<List<Integer>> getSubsets(List<Integer> set, int index) {
		List<List<Integer>> allsubsets;
		if (set.size() == index) { // Base case - add empty set
			allsubsets = new ArrayList<>();
			allsubsets.add(new ArrayList<Integer>()); 
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			List<List<Integer>> moresubsets = new ArrayList<>();
			for (List<Integer> subset : allsubsets) {
				List<Integer> newsubset = new ArrayList<>();
				newsubset.addAll(subset); 
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		List<List<Integer>> subsets = getSubsets(list, 0);
		System.out.println(subsets);
	}

}
