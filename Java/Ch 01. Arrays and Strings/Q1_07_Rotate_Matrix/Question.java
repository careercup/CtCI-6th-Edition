package Q1_07_Rotate_Matrix;

import CtCILibrary.*;

public class Question {

	public static boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
		int n = matrix.length;
		
		for (int layer = 1; layer <= n / 2; layer++) {
			for(int i = layer; i <= n-layer; i++) {
				int top = matrix[i-1][layer-1]; // save top

				// left -> top
				matrix[i-1][layer-1] = matrix[n-layer][i-1]; 			

				// bottom -> left
				matrix[n-layer][i-1] = matrix[n-i][n-layer]; 

				// right -> bottom
				matrix[n-i][n-layer] = matrix[layer-1][n-i]; 

				// top -> right
				matrix[layer-1][n-i] = top; // right <- saved top
			}
		}
		return true;
	}
	
	public static boolean rotateAnticlock(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
		int n = matrix.length;
		
		for (int layer = 1; layer <= n / 2; layer++) {
			for(int i = layer; i <= n-layer; i++) {
				int top = matrix[i-1][layer-1]; // save top

				// right -> top
				matrix[i-1][layer-1] = matrix[layer-1][n-i]; 			

				// bottom -> right
				matrix[layer-1][n-i] = matrix[n-i][n-layer]; 

				// left -> bottom
				matrix[n-i][n-layer] = matrix[n-layer][i-1]; 

				// top -> bottom
				matrix[n-layer][i-1] = top; // right <- saved top
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
		
		rotateAnticlock(matrix);
		System.out.println();
		AssortedMethods.printMatrix(matrix);
	}

}
