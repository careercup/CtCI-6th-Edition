package Q6_10_Test_Strips;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionC {
	public static List<Bottle> createBottles(int nBottles, int poisoned) {
		List<Bottle> bottles = new ArrayList<>();
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

	public static int findPoisonedBottle(List<Bottle> bottles, List<TestStrip> strips) {
		runTests(bottles, strips);
		List<Integer> positive = getPositiveOnDay(strips, 7);
		return setBits(positive);
	}	
	
	/* Add bottles to test strips */
	public static void runTests(List<Bottle> bottles, List<TestStrip> testStrips) {
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
	public static List<Integer> getPositiveOnDay(List<TestStrip> testStrips, int day) {
		List<Integer> positive = new ArrayList<>();
		for (TestStrip testStrip : testStrips) {
			int id = testStrip.getId();
			if (testStrip.isPositiveOnDay(day)) {
				positive.add(id);
			}
		}
		return positive;
	}
	
	/* Create number by setting bits with indices specified in positive. */
	public static int setBits(List<Integer> positive) {
		int id = 0;
		for (Integer bitIndex : positive) {
			id |= 1 << bitIndex;
		}
		return id;
	}

	public static List<TestStrip> createTestStrips(int nTestStrips) {
		List<TestStrip> testStrips = new ArrayList<>();
		for (int i = 0; i < nTestStrips; i++) {
			testStrips.add(new TestStrip(i));
		}
		return testStrips;
	}
	
	public static void main(String[] args) {
		int nBottles = 1000;
		int nTestStrips = 10;
		for (int poisoned = 0; poisoned < nBottles; poisoned++) {
			List<Bottle> bottles = createBottles(nBottles, poisoned);
			List<TestStrip> testStrips = createTestStrips(nTestStrips);
			int poisonedId = findPoisonedBottle(bottles, testStrips);
			System.out.println("Suspected Bottle: " + poisonedId);
			if (poisonedId != poisoned) {
				System.out.println("ERROR");
				break;
			}
		}
	}
}
