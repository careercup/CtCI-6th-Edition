package Q1_07_Rotate_Matrix;

import CtCILibrary.*;

public class Question {

	public static boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
		int n = matrix.length;
		
		for (int row = 0; row < n; row++) {
            		for (int col = 0; col < n; col++) {
                		if (col > row) { // Using the upper diagonal values
				    int temp = matrix[row][col];
				    matrix[row][col] = matrix[col][row];
				    matrix[col][row] = temp;
                		}
            		}
        	}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
		AssortedMethods.printMatrix(matrix);
		rotate(matrix);
		System.out.println();
		AssortedMethods.printMatrix(matrix);
	}

}
