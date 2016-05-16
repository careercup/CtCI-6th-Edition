package Q6_10_Test_Strips;

public class Bottle {
	private boolean poisoned = false;
	private int id;
	
	public Bottle(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setAsPoisoned() {
		poisoned = true;
	}
	
	public boolean isPoisoned() {
		return poisoned;
	}
}
