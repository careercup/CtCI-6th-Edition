package Q17_24_Max_Submatrix;

import CtCILibrary.AssortedMethods;

public class QuestionC {	
	public static SubMatrix getMaxMatrix(int[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;
	
		SubMatrix best = null;
	
		for (int rowStart = 0; rowStart < rowCount; rowStart++) {
			int[] partialSum = new int[colCount];
		
			for (int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
				/* Add values at row rowEnd. */
				for (int i = 0; i < colCount; i++) {
					partialSum[i] += matrix[rowEnd][i];
				}
		
				Range bestRange = maxSubArray(partialSum, colCount);
				if (best == null || best.getSum() < bestRange.sum) {
					best = new SubMatrix(rowStart, bestRange.start, rowEnd, bestRange.end, bestRange.sum);
				}
			}
		}
		return best;
	}

	public static Range maxSubArray(int[] array, int N) {
		Range best = null;
		int start = 0;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += array[i];
			if (best == null || sum > best.sum) {
				best = new Range(start, i, sum);
			}
			
			/* If running_sum is < 0 no point in trying to continue the 
			 * series. Reset. */
			if (sum < 0) {
				start = i + 1;
				sum = 0;
			}
		}
		return best;
	}
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(10, 10, -5, 5);
		AssortedMethods.printMatrix(matrix);
		System.out.println(getMaxMatrix(matrix));
	}

}
