package Introduction;

public class Circle extends Shape {
	private double rad = 5;
	public void printMe() {
		System.out.println("I am a circle.");
	}
	
	public double computeArea() {
		return rad * rad * 3.15;
	}
}
