package Q13_08_Lambda_Random;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QuestionC {
	public static Random random = new Random();
	public static Predicate<Object> flipCoin = o -> {
		return random.nextBoolean();
	};

	public static List<Integer> getRandomSubset(List<Integer> list) {
 		List<Integer> subset = list.stream().filter(flipCoin).
 			collect(Collectors.toList());
 		return subset;
	}

	public static void main(String... args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
 		List<Integer> subset = getRandomSubset(list);
		System.out.println(subset);
 	}

}