package Q16_22_Langtons_Ant;

public class Grid {	
	private boolean[][] grid; // false is white, true is black
	private Ant ant = new Ant();
	
	public Grid() {
		grid = new boolean[1][1];
	}
	
	/* Copy old values into new array, with an offset/shift applied to the row and columns. */
	private void copyWithShift(boolean[][] oldGrid, boolean[][] newGrid, int shiftRow, int shiftColumn) {
		for (int r = 0; r < oldGrid.length; r++) {
			for (int c = 0; c < oldGrid[0].length; c++) {
				newGrid[r + shiftRow][c + shiftColumn] = oldGrid[r][c];
			}
		}
	}
	
	/* Ensure that the given position will fit on the array. If 
	 * necessary, double the size of the matrix, copy the old values 
	 * over, and adjust the ant's position so that it's in a positive
	 * ranges.
	 */
	private void ensureFit(Position position) {
		int shiftRow = 0;
		int shiftColumn = 0;
		
		/* Calculate new number of rows. */
		int numRows = grid.length;
		if (position.row < 0) {
			shiftRow = numRows;
			numRows *= 2;
		} else if (position.row >= numRows) {
			numRows *= 2;
		}
		
		/* Calculate new number of columns. */
		int numColumns = grid[0].length;
		if (position.column < 0) {
			shiftColumn = numColumns;
			numColumns *= 2;
		} else if (position.column >= numColumns) {
			numColumns *= 2;
		}
		
		/* Grow array, if necessary. Shift ant's position too. */
		if (numRows != grid.length || numColumns != grid[0].length) {
			boolean[][] newGrid = new boolean[numRows][numColumns];
			copyWithShift(grid, newGrid, shiftRow, shiftColumn);
			ant.adjustPosition(shiftRow, shiftColumn);
			grid = newGrid;
		}
	}
	
	/* Flip color of cells. */
	private void flip(Position position) {
		int row = position.row;
		int column = position.column;
		grid[row][column] = grid[row][column] ? false : true;
	}
	
	/* Move ant. */
	public void move() {
		ant.turn(!grid[ant.position.row][ant.position.column]); // Turn clockwise on white, counterclockwise on black
		flip(ant.position); // flip
		ant.move(); // move
		ensureFit(ant.position); // grow
	}
	
	/* Print board. The first loop of this is a "compression" which only prints the active parts of the board. The active
	 * board is the smallest rectangle that contains all the black cells and the ant. This is fairly optional. Nice to do
	 * but also not essential. 
	 * FULL BOARD:    ACTIVE BOARD:
	 *  _____          _X
	 *  ___X_          XX
	 *  __XX_           X
	 *  ___X_
	 *  _____
	 *  _____*/
	public String toString() {
		int firstActiveRow = grid.length;
		int firstActiveColumn = grid[0].length;
		int lastActiveRow = 0;
		int lastActiveColumn = 0;		
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] || (ant.position.row == r && ant.position.column == c)) { // If there's something there
					firstActiveRow = Math.min(firstActiveRow, r);
					firstActiveColumn = Math.min(firstActiveColumn, c);
					lastActiveRow = Math.max(lastActiveRow, r);
					lastActiveColumn = Math.max(lastActiveColumn, c);
				}
			}
		}		
		
		StringBuilder sb = new StringBuilder();
		for (int r = firstActiveRow; r <= lastActiveRow; r++) {
			for (int c = firstActiveColumn; c <= lastActiveColumn; c++) {
				if (r == ant.position.row && c == ant.position.column) {
					sb.append(ant.orientation);
				} else if (grid[r][c]) {
					sb.append("X");
				} else {
					sb.append("_");
				}
			}
			sb.append("\n");
		}
		sb.append("Ant: " + ant.orientation + ". \n");
		return sb.toString();
	}
}
