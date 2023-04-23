package Introduction;

public class Square extends Shape {
	private double len = 5;
	public void printMe() {
		System.out.println("I am a square.");
	}
	
	public double computeArea() {
		return len * len;
	}	
}
