import CtCILibrary.*;

public class Answer {
	public static int[][] rotateMatrix(int[][] matrix) {
		int size = matrix.length;
		for (int i = 0; i <= size/2 - 1; i++) {
			int top = 0;
			for (int j = i; j <= size - 2 - i; j++) {
				top = matrix[i][j];
				matrix[i][j] = matrix[size - 1 - j][i];
				matrix[size - 1 - j][i] = matrix[size - 1 - i][size - 1 - j];
				matrix[size - 1 - i][size - 1 - j] = matrix[j][size - 1 - i];
				matrix[j][size - 1 - i] = top;
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(4, 4, 0, 9);
		AssortedMethods.printMatrix(matrix);
		System.out.println();
		AssortedMethods.printMatrix(rotateMatrix(matrix));
	}
}