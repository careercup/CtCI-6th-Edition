package Q16_10_Living_People;

import java.util.Random;

public class Tester {

	
	
	public static void main(String[] args) {
		int n = 100;
		int first = 1900;
		int last = 2000;
		
		Random random = new Random();
		Person[] people = new Person[n + 1];
		for (int i = 0; i < n; i++) {
			int birth = first + random.nextInt(last - first);
			int death = birth + random.nextInt(last - birth);
			people[i] = new Person(birth, death);
			//System.out.println(birth + ", " + death);
		}
		people[n] = new Person(first, first);
		
		int yearA = QuestionA.maxAliveYear(people, first, last);
		int yearB = QuestionB.maxAliveYear(people, first, last);
		int yearC = QuestionC.maxAliveYear(people, first, last);
		int yearD = QuestionD.maxAliveYear(people, first, last);
		System.out.println("A: " + yearA);
		System.out.println("B: " + yearB);
		System.out.println("C: " + yearC);
		System.out.println("D: " + yearD);
	}

}
