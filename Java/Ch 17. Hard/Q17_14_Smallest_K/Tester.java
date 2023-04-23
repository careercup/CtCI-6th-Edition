package Q17_14_Smallest_K;

import java.util.Arrays;

import CtCILibrary.AssortedMethods;

public class Tester {

	public static int rankB(int[] array, int rank) {
		int[] cloned = array.clone();
		Arrays.sort(cloned);
		return cloned[rank];
	}
	
	public static void swap(int[] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
	
	public static boolean isUnique(int[] array) {
		int[] cloned = array.clone();
		Arrays.sort(cloned);
		for (int i = 1; i < cloned.length; i++) {
			if (cloned[i] == cloned[i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	public static int max(int[] array, int left, int right) {
		int max = Integer.MIN_VALUE;
		for (int i = left; i <= right; i++) {
			max = Math.max(array[i], max);
		}
		return max;
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	
	public static boolean isEqual(int[] array1, int[] array2) {
		if (array1.length != array2.length) {
			return false;
		}
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isEquivalent(int[] array1, int[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);
		return isEqual(array1, array2);
	}
	
	public static boolean testArray(int[] array1) {
		int[] copy = array1.clone();
		int[] array2 = new int[array1.length];
		for (int i = 0; i < array1.length; i++) {
			array2[i] = QuestionD.rank(array1, i);
		}
		
		Arrays.sort(array1);
		if (!isEqual(array1, array2)) {
			System.out.println("ERROR");
			System.out.println("Original Array: " + AssortedMethods.arrayToString(copy));
			System.out.println("Ranked Array:   " + AssortedMethods.arrayToString(array2));
			System.out.println("Sorted Array:   " + AssortedMethods.arrayToString(array1));
			return false;
		}
		return true;
	}	

	public static void main(String[] args) {
		int numberOfTests = 1000;
		int countWithC = 0;
		int countTotal = 0;
		
		for (int i = 0; i < numberOfTests; i++) {
			int length = AssortedMethods.randomIntInRange(1, 10);
			int rank = AssortedMethods.randomIntInRange(1, length);
			int minRange = -1 * i;
			int maxRange = i;
			
			
			int[] array = AssortedMethods.randomArray(length, minRange, maxRange);
			int[] smallestA = QuestionA.smallestK(array.clone(), rank);
			int[] smallestB = QuestionB.smallestK(array.clone(), rank);
			int[] smallestD = QuestionD.smallestK(array.clone(), rank);
			int[] smallestC = smallestD;
			if (isUnique(array)) {
				smallestC = QuestionC.smallestK(array.clone(), rank);
				countWithC++;
			}
			countTotal++;
			if (!isEquivalent(smallestA, smallestB) || !isEquivalent(smallestB, smallestD) || !isEquivalent(smallestD, smallestC)) {
				System.out.println("ERROR");
				System.out.println(array);
				System.out.println("ArrayA: " + AssortedMethods.arrayToString(smallestA));
				System.out.println("ArrayA: " + AssortedMethods.arrayToString(smallestA));
				System.out.println("ArrayB: " + AssortedMethods.arrayToString(smallestB));
				System.out.println("ArrayC: " + AssortedMethods.arrayToString(smallestC));
				System.out.println("ArrayD: " + AssortedMethods.arrayToString(smallestD));
				
				break;
			}
		}
		System.out.println("Completed " + countTotal + " runs, including " + countWithC + " with C");
	}

}
