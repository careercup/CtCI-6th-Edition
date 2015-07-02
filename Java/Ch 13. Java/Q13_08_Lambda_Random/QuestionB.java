package Q13_08_Lambda_Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class QuestionB {	
	public static List<Integer> getRandomSubset(List<Integer> list) {
		Random random = new Random();
		List<Integer> subset = list.stream().filter( k -> {
			return random.nextBoolean(); /* Flip coin. */
		}).collect(Collectors.toList());
		return subset;
	}
	
 	public static void main(String... args) {	
 		List<Integer> list = new ArrayList<Integer>();
 		list.add(1);
 		list.add(2);
 		list.add(3);
 		list.add(4);
 		List<Integer> subset = getRandomSubset(list);
 		System.out.println(subset.toString());
 	}

}