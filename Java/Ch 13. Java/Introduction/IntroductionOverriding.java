package Introduction;

public class IntroductionOverriding {

	public static void printArea(Circle c) {
		System.out.println("The circle is " + c.computeArea());
	}
	
	public static void printArea(Square s) {
		System.out.println("The square is " + s.computeArea());
	}	
	
	public static void printArea(Ambiguous s) {
		System.out.println("The ambiguous is undefined");
	}	
	
	public static void main(String[] args) {
		Shape[] shapes = new Shape[2];
		Circle circle = new Circle();
		Ambiguous ambiguous = new Ambiguous();
		
		shapes[0] = circle;
		shapes[1] = ambiguous;
		
		for (Shape s : shapes) {
			s.printMe();
			System.out.println(s.computeArea());
		}
	}
}
