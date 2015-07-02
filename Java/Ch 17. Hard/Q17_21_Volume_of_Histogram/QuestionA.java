package Q17_21_Volume_of_Histogram;

public class QuestionA {

	public static int findIndexOfMax(int[] histogram, int start, int end) {
		int indexOfMax = start;
		for (int i = start + 1; i <= end; i++) {
			if (histogram[i] > histogram[indexOfMax]) {
				indexOfMax = i;
			}
		}
		return indexOfMax;
	}
	
	public static int borderedVolume(int[] histogram, int start, int end) {
		if (start >= end) return 0;
		
		int min = Math.min(histogram[start], histogram[end]);
		int sum = 0;
		for (int i = start + 1; i < end; i++) {
			sum += min - histogram[i];
		}
		return sum;
	}
	
	public static int subgraphVolume(int[] histogram, int start, int end, boolean isLeft) {
		if (start >= end) return 0;	
		int sum = 0;
		if (isLeft) {
			int max = findIndexOfMax(histogram, start, end - 1);
			sum += borderedVolume(histogram, max, end);
			sum += subgraphVolume(histogram, start, max, isLeft);
		} else {
			int max = findIndexOfMax(histogram, start + 1, end);
			sum += borderedVolume(histogram, start, max);
			sum += subgraphVolume(histogram, max, end, isLeft);
		} 
		
		return sum;
	}
	
	public static int computeHistogramVolume(int[] histogram) {
		int start = 0;
		int end = histogram.length - 1;
		
		int max = findIndexOfMax(histogram, start, end);
		
		int leftVolume =  subgraphVolume(histogram, start, max, true);
		int rightVolume = subgraphVolume(histogram, max, end, false);
		
		return leftVolume + rightVolume;		
	}
	
	public static void main(String[] args) {
		int[] histogram = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0, 3, 0, 0};
		int result = computeHistogramVolume(histogram);
		System.out.println(result);
	}

}
