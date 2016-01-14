package Q7_06_Jigsaw;

public enum Shape {
	INNER, OUTER, FLAT;
		
	public Shape getOpposite() {		
		switch (this) {
			case INNER: return OUTER;
			case OUTER: return INNER;
			default: return null;
		}
	}
}
