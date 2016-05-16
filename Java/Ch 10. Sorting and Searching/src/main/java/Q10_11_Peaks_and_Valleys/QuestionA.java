package Q10_11_Peaks_and_Valleys;

import java.util.Arrays;

import CtCILibrary.AssortedMethods;

public class QuestionA {
	public static void sortValleyPeak(int[] array) {
		Arrays.sort(array);
		for (int i = 1; i < array.length; i += 2) {
			swap(array, i - 1, i);
		}
	}
	
	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void main(String[] args) {
		int[] array = {48, 40, 31, 62, 28, 21, 64, 40, 23, 17};
		System.out.println(AssortedMethods.arrayToString(array));
		sortValleyPeak(array);
		System.out.println(AssortedMethods.arrayToString(array));
		System.out.println(Tester.confirmValleyPeak(array));
	}

}
