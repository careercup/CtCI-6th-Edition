package Q17_23_Max_Black_Square;

public class Subsquare {
	public int row, column, size;
	public Subsquare(int r, int c, int sz) {
		row = r;
		column = c;
		size = sz;
	}
	
	public void print() {
		System.out.println("(" + row + ", " + column + ", " + size + ")");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Subsquare other = (Subsquare) obj;
		return row == other.row && column == other.column && size == other.size;
	}
}