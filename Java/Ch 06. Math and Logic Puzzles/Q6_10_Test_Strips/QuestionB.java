package Q6_10_Test_Strips;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class QuestionB {
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

	public static int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {
		if (bottles.size() > 1000 || strips.size() < 10) return -1;
		
		int tests = 4; // three digits, plus one extra
		int nTestStrips = strips.size();
		
		/* Run tests. */
		for (int day = 0; day < tests; day++) {
			runTestSet(bottles, strips, day);
		}
		
		/* Get results. */
		HashSet<Integer> previousResults = new HashSet<Integer>();
		int[] digits = new int[tests];
		for (int day = 0; day < tests; day++) {
			int resultDay = day + TestStrip.DAYS_FOR_RESULT;
			digits[day] = getPositiveOnDay(strips, resultDay, previousResults);
			previousResults.add(digits[day]);
		}
		
		/* If day 1's results matched day 0's, update the digit. */
		if (digits[1] == -1) {
			digits[1] = digits[0];
		}
		
		/* If day 2 matched day 0 or day 1, check day 3. Day 3 is
		 * the same as day 2, but incremented by 1. */
		if (digits[2] == -1) { 
			if (digits[3] == -1) { /* Day 3 didn't give new result */
				/* Digit 2 equals digit 0 or digit 1. But, digit 2, when incremented also matches 
				 * digit 0 or digit 1. This means that digit 0 incremented matches digit 1, or the
				 * other way around. */
				digits[2] = ((digits[0] + 1) % nTestStrips) == digits[1] ? digits[0] : digits[1];  
			} else {
				digits[2] = (digits[3] - 1 + nTestStrips) % nTestStrips;
			}
		}
		
		return digits[0] * 100 + digits[1] * 10 + digits[2];
	}
	
	/* Run set of tests for this day. */
	public static void runTestSet(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips, int day) {
		if (day > 3) return; // only works for 3 days (digits) + one extra

		for (Bottle bottle : bottles) {
			int index = getTestStripIndexForDay(bottle, day, strips.size());
			TestStrip testStrip = strips.get(index);
			testStrip.addDropOnDay(day, bottle);
		}
	}
	
	/* Get test strip index that should be used on this bottle on this day. */ 
	public static int getTestStripIndexForDay(Bottle bottle, int day, int nTestStrips) {
		int id = bottle.getId();
		switch (day) {
			case 0: return id /100;
			case 1: return (id % 100) / 10;
			case 2: return id % 10;
			case 3: return (id % 10 + 1) % nTestStrips;
			default: return -1;
		}
	}	
	
	/* Get results that are positive for a particular day, excluding prior results. */
	public static int getPositiveOnDay(ArrayList<TestStrip> testStrips, int day, HashSet<Integer> previousResults) {
		for (TestStrip testStrip : testStrips) {
			int id = testStrip.getId();
			if (testStrip.isPositiveOnDay(day) && !previousResults.contains(id)) {
				return testStrip.getId();
			}
		}
		return -1;
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
