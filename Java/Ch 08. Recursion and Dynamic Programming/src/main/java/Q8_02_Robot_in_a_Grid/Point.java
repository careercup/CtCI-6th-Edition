package Q8_02_Robot_in_a_Grid;

public class Point {
	public int row, column;
	public Point(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
	
	@Override
	 public int hashCode() {
        return this.toString().hashCode();
    }
	
	@Override
	public boolean equals(Object o) {
		if ((o instanceof Point) && (((Point) o).row == this.row) && (((Point) o).column == this.column)) {
            return true;
        } else {
            return false;
        }
	}
}
