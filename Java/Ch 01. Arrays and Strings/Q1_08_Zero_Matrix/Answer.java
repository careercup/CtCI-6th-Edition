import CtCILibrary.AssortedMethods;
import java.util.ArrayList;

public class Answer {
	public static int[][] zeroMatrix(int[][] matrix) {
		if (matrix.length == 0)	return matrix;
		ArrayList<Integer> row = new ArrayList<>();
		ArrayList<Integer> col = new ArrayList<>();
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row.add(i);
					col.add(j);
				}
			}
		}
		for (int i = 0; i < row.size(); i++) {
			for (int j = 0; j < n; j++){
				matrix[row.get(i)][j] = 0;
			}
		}
		for (int j = 0; j < col.size(); j++) {
			for (int i = 0; i < m; i++){
				matrix[i][col.get(j)] = 0;
			}
		}
		return matrix;
	}

	public static boolean matricesAreEqual(int[][] m1, int[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length) {
			return false;
		}
		
		for (int k = 0; k < m1.length; k++) {
			for (int j = 0; j < m1[0].length; j++) {
				if (m1[k][j] != m2[k][j]) {
					return false;
				}
			}
		}	
		return true;
	}
	
	public static int[][] cloneMatrix(int[][] matrix) {
		int[][] c = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				c[i][j] = matrix[i][j];
			}
		}
		return c;
	}

	public static void main(String[] args){
		int nrows = 5;
		int ncols = 6;
		int[][] matrix = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);
		
		System.out.println();
		AssortedMethods.printMatrix(matrix);
		System.out.println();
		AssortedMethods.printMatrix(zeroMatrix(matrix));
	}
}