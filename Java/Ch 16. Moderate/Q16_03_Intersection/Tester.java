package Q16_03_Intersection;

import java.util.ArrayList;

public class Tester {

	public static boolean equalish(double a, double b) {
		return Math.abs(a - b) < .001;
	}

	public static boolean checkIfPointOnLineSegments(Point start, Point middle, Point end) {
		if (equalish(start.x, middle.x) && equalish(start.y, middle.y)) {
			return true;
		}
		if (equalish(middle.x, end.x) && equalish(middle.y, end.y)) {
			return true;
		}
		if (start.x == end.x) { // Vertical
			if (equalish(start.x, middle.x)) {
				return Question.isBetween(start, middle, end); 
			}
			return false;
		}
		Line line = new Line(start, end);
		double x = middle.x;
		double y = line.slope * x + line.yintercept;
		if (equalish(y, middle.y)) {
			return true;
		}
		return false;
	}

	public static ArrayList<Point> getPoints(int size) {
		ArrayList<Point> points = new ArrayList<Point>();
		for (int x1 = size * -1; x1 < size; x1+=3) {
			for (int y1 = size * -1 + 1; y1 < size - 1; y1+=3) {
				points.add(new Point(x1, y1));
			}
		}
		return points;
	}

	public static boolean runTest(Point start1, Point end1, Point start2, Point end2) {
		Point intersection = Question.intersection(start1, end1, start2, end2);
		boolean validate1 = true;
		boolean validate2 = true;
		if (intersection == null) {
			System.out.println("No intersection.");
		} else {
			validate1 = checkIfPointOnLineSegments(start1, intersection, end1);
			validate2 = checkIfPointOnLineSegments(start2, intersection, end2);
			if (validate1 && validate2) {
				System.out.println("has intersection");
			}
			if (!validate1 || !validate2) {
				System.out.println("ERROR -- " + validate1 + ", " + validate2);
			}
		}

		System.out.println("  Start1: " + start1.x + ", " + start1.y);
		System.out.println("  End1: " + end1.x + ", " + end1.y);
		System.out.println("  Start2: " + start2.x + ", " + start2.y);
		System.out.println("  End2: " + end2.x + ", " + end2.y);
		if (intersection != null) {
			System.out.println("  Intersection: " + intersection.x + ", " + intersection.y);
		}

		if (!validate1 || !validate2) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		ArrayList<Point> points = getPoints(10);
		for (Point start1 : points) {
			for (Point end1 : points) {
				for (Point start2 : points) {
					for (Point end2 : points) {
						boolean success = runTest(start1, end1, start2, end2);
						if (!success) {
							return;
						}
					}
				}
			}
		}
	}

}
