package Q6_10_Test_Strips;

import java.util.ArrayList;
import java.util.Random;

public class QuestionC {
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
		runTests(bottles, strips);
		ArrayList<Integer> positive = getPositiveOnDay(strips, 7);
		return setBits(positive);
	}	
	
	/* Add bottles to test strips */
	public static void runTests(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips) {
		for (Bottle bottle : bottles) {
			int id = bottle.getId();
			int bitIndex = 0;
			while (id > 0) {
				if ((id & 1) == 1) {
					testStrips.get(bitIndex).addDropOnDay(0, bottle);
				}
				bitIndex++;
				id >>= 1;
			}
		}
	}
	
	/* Get test strips that are positive on a particular day. */
	public static ArrayList<Integer> getPositiveOnDay(ArrayList<TestStrip> testStrips, int day) {
		ArrayList<Integer> positive = new ArrayList<Integer>();
		for (TestStrip testStrip : testStrips) {
			int id = testStrip.getId();
			if (testStrip.isPositiveOnDay(day)) {
				positive.add(id);
			}
		}
		return positive;
	}
	
	/* Create number by setting bits with indices specified in positive. */
	public static int setBits(ArrayList<Integer> positive) {
		int id = 0;
		for (Integer bitIndex : positive) {
			id |= 1 << bitIndex;
		}
		return id;
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
