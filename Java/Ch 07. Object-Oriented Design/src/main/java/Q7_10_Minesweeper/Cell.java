package Q7_10_Minesweeper;

public class Cell {
	private int row;
	private int column;
	private boolean isBomb;
	private int number;
	private boolean isExposed = false;
	private boolean isGuess = false;
	
	public Cell(int r, int c) {
		isBomb = false;
		number = 0;
		row = r;
		column = c;
	}
	
	public void setRowAndColumn(int r, int c) {
		row = r;
		column = c;
	}
	
	public void setBomb(boolean bomb) {
		isBomb = bomb;
		number = -1;
	}
	
	public void incrementNumber() {
		number++;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public boolean isBomb() {
		return isBomb;
	}
	
	public boolean isBlank() {
		return number == 0;
	}
	
	public boolean isExposed() {
		return isExposed;
	}
	
	public boolean flip() {
		isExposed = true;
		return !isBomb;
	}
	
	public boolean toggleGuess() {
		if (!isExposed) {
			isGuess = !isGuess;
		}
		return isGuess;
	}
	
	public boolean isGuess() {
		return isGuess;
	}
	
	@Override
	public String toString() {
		return getUndersideState();
	}
	
	public String getSurfaceState() {
		if (isExposed) {
			return getUndersideState();
		} else if (isGuess) {
			return "B ";
		} else {
			return "? ";
		}
	}
	
	public String getUndersideState() {
		if (isBomb) {
			return "* ";
		} else if (number > 0) {
			return Integer.toString(number) + " ";
		} else {
			return "  ";
		}		
	}
}
