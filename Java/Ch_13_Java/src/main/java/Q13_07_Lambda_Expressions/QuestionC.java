package Q13_07_Lambda_Expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class QuestionC {
	public static int getPopulation(List<Country> countries, String continent) {
 		Stream<Integer> populations = countries.stream().map(c -> 
 			c.getContinent().equals(continent) ? c.getPopulation() : 0);
 		return populations.reduce(0, (a, b) -> a + b);
	}	
	
 	public static void main(String... args) {		
 		ArrayList<Country> countries = new ArrayList<Country>();
 		countries.add(new Country("United States", "North America", 5));
 		countries.add(new Country("Canada", "North America", 10));
 		countries.add(new Country("India", "Asia", 30));
 		System.out.println(getPopulation(countries, "North America"));
 	}

}