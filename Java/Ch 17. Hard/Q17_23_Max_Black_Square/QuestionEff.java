package Q17_23_Max_Black_Square;

import CtCILibrary.AssortedMethods;

public class QuestionEff {
	public static Subsquare findSquareWithSize(SquareCell[][] processed, int square_size) {
		// On an edge of length N, there are (N - sz + 1) squares of length sz.
		int count = processed.length - square_size + 1; 
		
		// Iterate through all squares with side length square_size.
		for (int row = 0; row < count; row++) {
			for (int col = 0; col < count; col++) {
				if (isSquare(processed, row, col, square_size)) {
					return new Subsquare(row, col, square_size);
				}
			}
		}
		return null;
	}
	
	public static Subsquare findSquare(int[][] matrix){
		assert(matrix.length > 0);
		for (int row = 0; row < matrix.length; row++){
			assert(matrix[row].length == matrix.length);
		}
		
		SquareCell[][] processed = processSquare(matrix);
		
		int N = matrix.length;
		
		for (int i = N; i >= 1; i--) {
			Subsquare square = findSquareWithSize(processed, i);
			if (square != null) {
				return square;
			}
		}
		return null;
	}	

	private static boolean isSquare(SquareCell[][] matrix, int row, int col, int size) {
		SquareCell topLeft = matrix[row][col];
		SquareCell topRight = matrix[row][col + size - 1];
		SquareCell bottomRight = matrix[row + size - 1][col];
		if (topLeft.zerosRight < size) { // Check top edge
			return false;
		}
		if (topLeft.zerosBelow < size) { // Check left edge
			return false;
		}
		if (topRight.zerosBelow < size) { // Check right edge
			return false;
		}
		if (bottomRight.zerosRight < size) { // Check bottom edge
			return false;
		}
		return true;
	}
	
	public static SquareCell[][] processSquare(int[][] matrix) {
		SquareCell[][] processed = new SquareCell[matrix.length][matrix.length];
		
		for (int r = matrix.length - 1; r >= 0; r--) {
			for (int c = matrix.length - 1; c >= 0; c--) {
				int rightZeros = 0;
				int belowZeros = 0;
				if (matrix[r][c] == 0) { // only need to process if it's a black cell
					rightZeros++;
					belowZeros++;
					if (c + 1 < matrix.length) { // next column over is on same row
						SquareCell previous = processed[r][c + 1];
						rightZeros += previous.zerosRight;
					}
					if (r + 1 < matrix.length) {
						SquareCell previous = processed[r + 1][c];
						belowZeros += previous.zerosBelow;
					}
				}
				processed[r][c] = new SquareCell(rightZeros, belowZeros);
			}
		}	
		return processed;
	}
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(7, 7, 0, 1);
		AssortedMethods.printMatrix(matrix);
		Subsquare square = findSquare(matrix);
		square.print();
	}
}
