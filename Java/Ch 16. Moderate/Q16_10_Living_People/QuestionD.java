package Q16_10_Living_People;

import java.util.Random;

public class QuestionD {
	
	public static int maxAliveYear(Person[] people, int min, int max) {
		/* Build population delta array. */
		int[] populationDeltas = getPopulationDeltas(people, min, max);
		int maxAliveYear = getMaxAliveYear(populationDeltas);
		return maxAliveYear + min;
	}
	
	/* Add birth and death years to deltas array. */
	public static int[] getPopulationDeltas(Person[] people, int min, int max) {
		int[] populationDeltas = new int[max - min + 2];
		for (Person person : people) {
			int birth = person.birth - min;
			populationDeltas[birth]++;
			
			int death = person.death - min;
			populationDeltas[death + 1]--;	
		}
		return populationDeltas;
	}
	
	/* Compute running sums and return index with max. */
	public static int getMaxAliveYear(int[] deltas) {
		int maxAliveYear = 0;
		int maxAlive = 0;
		int currentlyAlive = 0;
		for (int year = 0; year < deltas.length; year++) {
			currentlyAlive += deltas[year];
			if (currentlyAlive > maxAlive) {
				maxAliveYear = year;
				maxAlive = currentlyAlive;
			}
		}	
		
		return maxAliveYear;
	}
	
	public static void main(String[] args) {
		int n = 3;
		int first = 1900;
		int last = 2000;
		Random random = new Random();
		Person[] people = new Person[n];
		for (int i = 0; i < n; i++) {
			int birth = first + random.nextInt(last - first);
			int death = birth + random.nextInt(last - birth);
			people[i] = new Person(birth, death);
			System.out.println(birth + ", " + death);
		}
		int year = maxAliveYear(people, first, last);
		System.out.println(year);
	}

}
