package Q6_10_Test_Strips;

import java.util.ArrayList;

public class TestStrip {
	public static int DAYS_FOR_RESULT = 7; 
	private ArrayList<ArrayList<Bottle>> dropsByDay = new ArrayList<ArrayList<Bottle>>();
	private int id;
	
	public TestStrip(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	/* Resize list of days/drops to be large enough. */
	private void sizeDropsForDay(int day) {
		while (dropsByDay.size() <= day) {
			dropsByDay.add(new ArrayList<Bottle>());
		}
	}
	
	/* Add drop from bottle on specific day. */
	public void addDropOnDay(int day, Bottle bottle) {
		sizeDropsForDay(day);
		ArrayList<Bottle> drops = dropsByDay.get(day);
		drops.add(bottle);
	}
	
	/* Checks if any of the bottles in the set are poisoned. */
	private boolean hasPoison(ArrayList<Bottle> bottles) {
		for (Bottle b : bottles) {
			if (b.isPoisoned()) {
				return true;
			}
		}
		return false;
	}
	
	/* Gets bottles that were used in the test DAYS_FOR_RESULT days ago. */ 
	public ArrayList<Bottle> getLastWeeksBottles(int day) {
		if (day < DAYS_FOR_RESULT) {
			return null;
		}
		return dropsByDay.get(day - DAYS_FOR_RESULT);
	}
	
	/* Checks if the test strip has had any poisoned bottles since before DAYS_FOR_RESULT */
	public boolean isPositiveOnDay(int day) {
		int testDay = day - DAYS_FOR_RESULT;
		if (testDay < 0 || testDay >= dropsByDay.size()) {
			return false;
		}
		for (int d = 0; d <= testDay; d++) {
			ArrayList<Bottle> bottles = dropsByDay.get(d);
			if (hasPoison(bottles)) {
				return true;
			}
		}
		return false;
	}
}
