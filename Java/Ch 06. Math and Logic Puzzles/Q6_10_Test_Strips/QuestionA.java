package Q6_10_Test_Strips;

import java.util.ArrayList;
import java.util.Random;

public class QuestionA {
	public static int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {
		int today = 0;
		
		while (bottles.size() > 1 && strips.size() > 0) {
			/* Run tests. */
			runTestSet(bottles, strips, today);
			
			/* Wait for results. */
			today += TestStrip.DAYS_FOR_RESULT;
			
			/* Check results. */
			for (TestStrip strip : strips) {
				if (strip.isPositiveOnDay(today)) {
					bottles = strip.getLastWeeksBottles(today);
					strips.remove(strip);
					break;
				}
			}
		}
	
		if (bottles.size() == 1) {
			System.out.println("Suspected bottle is " + bottles.get(0).getId() + " on day " + today);
			return bottles.get(0).getId();
		}
		return -1;	
	}	
	
	public static void runTestSet(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips, int day) {
		int index = 0;
		for (Bottle bottle : bottles) {
			TestStrip strip = strips.get(index);
			strip.addDropOnDay(day, bottle);
			index = (index + 1) % strips.size();
		}
	}
	
	public static ArrayList<Bottle> createBottles(int nBottles, int poisoned) {
		ArrayList<Bottle> bottles = new ArrayList<Bottle>();
		for (int i = 0; i < nBottles; i++) {
			bottles.add(new Bottle(i));
		}
		
		if (poisoned == -1) {
			Random random = new Random();
			poisoned = random.nextInt(nBottles);
		}
		bottles.get(poisoned).setAsPoisoned();
		
		System.out.println("Added poison to bottle " + poisoned);
		
		return bottles;
	}
	
	public static ArrayList<TestStrip> createTestStrips(int nTestStrips) {
		ArrayList<TestStrip> testStrips = new ArrayList<TestStrip>();
		for (int i = 0; i < nTestStrips; i++) {
			testStrips.add(new TestStrip(i));
		}
		return testStrips;
	}
	
	public static void main(String[] args) {
		int nBottles = 1000;
		int nTestStrips = 10;
		for (int poisoned = 0; poisoned < nBottles; poisoned++) {
			ArrayList<Bottle> bottles = createBottles(nBottles, poisoned);
			ArrayList<TestStrip> testStrips = createTestStrips(nTestStrips);
			int poisonedId = findPoisonedBottle(bottles, testStrips);
			System.out.println("Suspected Bottle: " + poisonedId);
			if (poisonedId != poisoned) {
				System.out.println("ERROR");
				break;
			}
		}
	}
}
