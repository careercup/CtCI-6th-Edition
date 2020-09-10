package Q1_07_Rotate_Matrix;

import CtCILibrary.AssortedMethods;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(4, 4, 0, 9);
		AssortedMethods.printMatrix(matrix);
		rotate(matrix);
		System.out.println();
		AssortedMethods.printMatrix(matrix);
		
		rotateAnticlock(matrix);
		System.out.println();
		AssortedMethods.printMatrix(matrix);

	}
	
	private static void rotateAnticlock(int[][] matrix) {
		// TODO Auto-generated method stub
		
	}

	private static void rotate(int[][] matrix) {
		
		int layers = matrix.length/2;
		
		for(int layer=1;layer <= layers; layer ++) {
			
			int elementsOfLayer = matrix.length / layer;
			for(int index = layer ; index < elementsOfLayer ; index ++) {
				
				int temp = matrix [index-1] [elementsOfLayer - layer];
				matrix [index-1] [elementsOfLayer - layer] = matrix [layer-1] [index - 1];
				matrix [layer-1] [index - 1] = matrix [elementsOfLayer-index] [layer - 1] ;
				matrix [elementsOfLayer-index] [layer - 1] = matrix [elementsOfLayer-layer] [elementsOfLayer - index];
				matrix [elementsOfLayer-layer] [elementsOfLayer - index] = temp;
				
				
			}
		}
		
	}
	

}
