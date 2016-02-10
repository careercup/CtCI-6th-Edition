package Q8_04_Power_Set;

import java.util.ArrayList;
import java.util.List;

public class QuestionB {

	public static List<Integer> convertIntToSet(int x, List<Integer> set) {
		List<Integer> subset = new ArrayList<>();
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}

	public static List<List<Integer>> getSubsets(List<Integer> set) {
		List<List<Integer>> allsubsets = new ArrayList<>();
		int max = 1 << set.size(); /* Compute 2^n */ 
		for (int k = 0; k < max; k++) {
			List<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}

		List<List<Integer>> subsets2 = getSubsets(list);
		System.out.println(subsets2.toString());		
	}

}
