package Q8_13_Stack_of_Boxes;

public class Box {
	public int width;
	public int height;
	public int depth;
	public Box(int w, int h, int d) {
		width = w;
		height = h;
		depth = d;
	}
	
	public boolean canBeUnder(Box b) {
		return width > b.width
			   && height > b.height
			   && depth > b.depth;
	}
	
	public boolean canBeAbove(Box b) {
		return b == null
			   || width < b.width
				  && height < b.height
				  && depth < b.depth;
	}
	
	public String toString() {
		return "Box(" + width + "," + height + "," + depth + ")";
	}
}
