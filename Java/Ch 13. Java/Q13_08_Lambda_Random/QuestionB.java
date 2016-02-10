package Q13_08_Lambda_Random;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class QuestionB {
	public static List<Integer> getRandomSubset(Collection<Integer> list) {
		Random random = new Random();
		List<Integer> subset = list.stream().filter( k -> {
			return random.nextBoolean(); /* Flip coin. */
		}).collect(Collectors.toList());
		return subset;
	}

	public static void main(String... args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
 		List<Integer> subset = getRandomSubset(list);
 		System.out.println(subset.toString());
 	}

}