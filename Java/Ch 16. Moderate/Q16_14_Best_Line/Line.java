package Q16_14_Best_Line;

public class Line {
	public static double epsilon = .5;
	public double slope;
	public double intercept;
	
	private boolean infinite_slope = false;
	
	public Line(GraphPoint p, GraphPoint q) {
		if (Math.abs(p.x - q.x) > epsilon) { // if x�s are different
			slope = (p.y - q.y) / (p.x - q.x); // compute slope
			intercept = p.y - slope * p.x; // y intercept from y=mx+b
		} else {
			infinite_slope = true;
			intercept = p.x; // x-intercept, since slope is infinite
		}
	}
	
	public boolean isEquivalent(double a, double b) {
		return (Math.abs(a - b) < epsilon);
	}
	
	public void Print() {
		System.out.println("y = " + slope + "x + " + intercept);
	}
		
	public static double floorToNearestEpsilon(double d) {
		int r = (int) (d / epsilon);
		return ((double) r) * epsilon;
	}
    
	public boolean isEquivalent(Object o) {  
		Line l = (Line) o;
    	if (isEquivalent(l.slope, slope) && isEquivalent(l.intercept, intercept) && (infinite_slope == l.infinite_slope)) {
    		return true;
    	}
        return false;
    }      
}
