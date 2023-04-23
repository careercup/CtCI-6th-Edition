package Q17_24_Max_Submatrix;

import CtCILibrary.*;

public class QuestionB {
	public static SubMatrix getMaxMatrix(int[][] matrix) {
		SubMatrix best = null;
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;
		int[][] sumThrough = precomputeSums(matrix);
		
		for (int row1 = 0; row1 < rowCount; row1++) {
			for (int row2 = row1; row2 < rowCount; row2++) {
				for (int col1 = 0; col1 < columnCount; col1++) {
					for (int col2 = col1; col2 < columnCount; col2++) {
						int sum = sum(sumThrough, row1, col1, row2, col2);
						if (best == null || best.getSum() < sum) {
							best = new SubMatrix(row1, col1, row2, col2, sum);
						}
					}
				}
			}
		}
		return best;
	}
		
	private static int[][] precomputeSums(int[][] matrix) {
		int[][] sumThrough = new int[matrix.length][matrix[0].length];
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				int left = c > 0 ? sumThrough[r][c - 1] : 0;
				int top = r > 0 ? sumThrough[r - 1][c] : 0;
				int overlap = r > 0 && c > 0 ? sumThrough[r - 1][c - 1] : 0;
				sumThrough[r][c] = left + top - overlap + matrix[r][c];
			}
		}
		return sumThrough;
	}
	
	private static int sum(int[][] sumThrough, int r1, int c1, int r2, int c2) {
		int topAndLeft = r1 > 0 && c1 > 0 ? sumThrough[r1 - 1][c1 - 1] : 0;
		int left = c1 > 0 ? sumThrough[r2][c1 - 1] : 0;
		int top = r1 > 0 ? sumThrough[r1 - 1][c2] : 0;
		int full = sumThrough[r2][c2];
		return full - left - top + topAndLeft;
	}
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(10, 10, -5, 5);
		AssortedMethods.printMatrix(matrix);
		System.out.println(getMaxMatrix(matrix));
	}

}
