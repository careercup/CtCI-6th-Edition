package Q16_22_Langtons_Ant;

public class Grid {	
	private boolean[][] grid;
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
		ant.turn(grid[ant.position.row][ant.position.column]); // Turn
		flip(ant.position); // flip
		ant.move(); // move
		ensureFit(ant.position); // grow
	}
	
	/* Print board. */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
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
