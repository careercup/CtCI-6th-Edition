package Q16_13_Bisect_Squares;

public class Question {

	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static void printLine(Line l) {
		System.out.println(l.start.x + "\t" + l.start.y);
		System.out.println(l.end.x + "\t" + l.end.y);
	}
	
	public static void printSquare(Square s) {
		System.out.println(s.left + "\t" + s.top + "\t" + s.size);
	}	
	
	public static boolean isApproxEqual(double d1, double d2) {
		double epsilon = .001;	
		if (Math.abs(d1 - d2) < epsilon) {
			return true;
		}
		return false;
	}
	
	public static boolean isApproxEqual(Point p1, Point p2) {
		return isApproxEqual(p1.x, p2.x) && isApproxEqual(p1.y, p2.y); 
	}
	
	public static boolean doTest(Square s1, Square s2, Point start, Point end) {
		Line line = s1.cut(s2);
		boolean r = (isApproxEqual(line.start, start) && isApproxEqual(line.end, end)) || (isApproxEqual(line.start, end) && isApproxEqual(line.end, start));
		if (!r) {
			printSquare(s1);
			printSquare(s2);
			printLine(line);
			System.out.println(start.toString());
			System.out.println(end.toString());
			System.out.println();
			return r;
		}
		return r;
	}
	
	public static boolean doTestFull(Square s1, Square s2, Point start, Point end) {
		return doTest(s1, s2, start, end) && doTest(s2, s1, start, end);
	}
	
	public static void doTests() {
		// Equal
		doTestFull(new Square(1, 1, 5), new Square(1, 1, 5), new Point(3.5, 1), new Point(3.5, 6));	
		
		// Concentric
		doTestFull(new Square(1, 1, 5), new Square(2, 2, 3), new Point(3.5, 1), new Point(3.5, 6));
		
		// Partially overlapping -- side by side
		doTestFull(new Square(10, 10, 10), new Square(8, 10, 10), new Point(8, 15), new Point(20, 15));
		
		// Partially overlapping -- corners
		doTestFull(new Square(10, 10, 10), new Square(8, 7, 7), new Point(8.777777, 7), new Point(18.8888888, 20));		
		
		// Partially overlapping -- on top of each other
		doTestFull(new Square(10, 10, 10), new Square(8, 7, 15), new Point(8, 22), new Point(23, 7));		
		
		// Not overlapping -- side by side
		doTestFull(new Square(10, 10, 10), new Square(19, 25, 4), new Point(12.5, 10), new Point(22, 29));				
		
		// Not overlapping -- on top of each other
		doTestFull(new Square(10, 10, 10), new Square(4, 4, 3), new Point(4, 4), new Point(20, 20));		
		
		// Contained
		doTestFull(new Square(10, 10, 10), new Square(12, 14, 3), new Point(10, 16.66666), new Point(20, 13.333));			
	}
	
	public static void main(String[] args) {
		/* For an easy way to test these, open up Square Cut Tester.xlsx
		 * in the Chapter 7, Problem 5 folder. Copy and paste the exact 
		 * output from below into the file (including all tabs).
		 */
		doTests();
	}

}
