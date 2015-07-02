package Q16_22_Langtons_Ant;

public class Ant {
	public Position position = new Position(0, 0);
	public Orientation orientation = Orientation.right;
	
	public void turn(boolean clockwise) {
		orientation = orientation.getTurn(clockwise);
	}
	
	public void move() {
		if (orientation == Orientation.left) {
			position.column--;
		} else if (orientation == Orientation.right) {
			position.column++;
		} else if (orientation == Orientation.up) {
			position.row--;
		} else if (orientation == Orientation.down) {
			position.row++;
		}
	}
	
	public void adjustPosition(int shiftRow, int shiftColumn) {
		position.row += shiftRow;
		position.column += shiftColumn;
	}
}
