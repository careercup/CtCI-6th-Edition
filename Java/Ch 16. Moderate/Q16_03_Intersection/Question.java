package Q16_03_Intersection;

public class Question {

	/* Checks if middle is between start and end. */
	public static boolean isBetween(double start, double middle, double end) {
		if (start > end) {
			return end <= middle && middle <= start;
		} else {
			return start <= middle && middle <= end;
		}
	}

	/* Checks if middle is between start and end. */
	public static boolean isBetween(Point start, Point middle, Point end) {
		return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
	}

	public static Point intersection(Point start1, Point end1, Point start2, Point end2) {	
		/* Compute lines (including slope and y-intercept). */
		Line line1 = new Line(start1, end1);
		Line line2 = new Line(start2, end2);

		/* If the lines are parallel, then their extended lines must have same y-intercept.
		 * If so, check that the start or end of one point is on the other line. */
		if (line1.slope == line2.slope) {
			if (line1.yintercept != line2.yintercept) {
				return null;
			}

			/* Check if the start or end of one line is in the other. If so, return that point*/
			if (isBetween(start1, start2, end1)) return start2;
			else if (isBetween(start1, end2, end1)) return end2;
			else if (isBetween(start2, start1, end2)) return start1;
			else if (isBetween(start2, end1, end2)) return end1; 					
			else return null;			
		}

		/* Compute the intersection of the infinite lines, and then check if this falls within the
		 * boundary of the line segments. Note that at most one line is vertical. */

		/* Get intersection's x coordinate. If one is vertical, always use its x coordinate. 
		 * Otherwise, compute the intersection's x coordinate based on setting each line's y = mx + b equation
		 * equal and solving for x. */
		double x;
		if (line1.isVertical() || line2.isVertical()) { /* If a line is vertical, use its x coordinate. */
			x = line1.isVertical() ? line1.start.x : line2.start.x;
		} else { /* Set y = mx + b equations equal and solve for x */
			x =  (line2.yintercept - line1.yintercept) / (line1.slope - line2.slope);
		}

		/* Get insection's y coordinate using a non-vertical line. Note that if line1 is vertical
		 * then line 2 is not vertical (else it would have been caught earlier). */
		double y = line1.isVertical() ? line2.getYFromX(x) : line1.getYFromX(x);

		/* We now have the intersection of the infinite lines. Check if it's within the boundaries
		 * of each line segment. */
		Point intersection = new Point(x, y);
		if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
			return intersection;
		}

		return null;
	}

	public static void main(String[] args) {

		Point s1 = new Point(2147000000, 1);
		Point e1 = new Point(-2147000000, -1);
		Point s2 = new Point(-10, 0);
		Point e2 = new Point(0, 0);
		Point intersection = intersection(s1, e1, s2, e2);
		System.out.println("Line Segment 1: " + s1 + " to " + e1);
		System.out.println("Line Segment 2: " + s2 + " to " + e2);
		System.out.println("Intersection: " + (intersection == null ? "None" : intersection));
		if (intersection != null) {
			System.out.println("Intersection is on segment1: " + Tester.checkIfPointOnLineSegments(s1, intersection, e1));
			System.out.println("Intersection is on segment1: " + Tester.checkIfPointOnLineSegments(s2, intersection, e2));
		}
	}

}
