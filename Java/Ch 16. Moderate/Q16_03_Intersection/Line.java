package Q16_03_Intersection;

public class Line {
	public double slope;
	public double yintercept;
	public Point start;
	public Point end;
	
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
		if (start.x == end.x) {
			slope = Double.POSITIVE_INFINITY;
		} else {
			double deltaY = end.y - start.y;
			double deltaX = end.x - start.x;
			slope = deltaY / deltaX; 
			yintercept = end.y - slope * end.x;
		}
	}
	
	public boolean isVertical() {
		return slope == Double.POSITIVE_INFINITY || slope == Double.NEGATIVE_INFINITY;
	}
	
	@Override
	public String toString() {
		return "Line [slope=" + slope + ", yintercept=" + yintercept + ", start=" + start + ", end=" + end + "]";
	}

	public double getYFromX(double x) {
		if (isVertical()) {
			return Double.POSITIVE_INFINITY;
		}
		return slope * x + yintercept;
	}
	
	public double getXFromY(double y) {
		if (isVertical()) {
			return start.x;
		}
		return (y - yintercept) / slope;
	}
}