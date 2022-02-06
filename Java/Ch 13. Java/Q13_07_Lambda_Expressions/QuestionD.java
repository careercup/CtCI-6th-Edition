package Q13_07_Lambda_Expressions;

import java.util.ArrayList;
import java.util.List;

public class QuestionD {
    public static int getPopulation(List<Country> countries, String continent) {
        return countries.stream().filter(country -> country.getContinent().equals(continent))
                        .reduce(0, (partialPopulationResult, country) -> partialPopulationResult + country.getPopulation(), Integer::sum);
    }

    public static void main(String... args) {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(new Country("United States", "North America", 5));
        countries.add(new Country("Canada", "North America", 10));
        countries.add(new Country("India", "Asia", 30));
        System.out.println(getPopulation(countries, "North America"));
    }

}
