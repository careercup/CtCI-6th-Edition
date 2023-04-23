package Q17_16_The_Masseuse;

import CtCILibrary.AssortedMethods;

public class Tester {
	public static int[] generateRandomArray(int size) {
		int[] array = AssortedMethods.randomArray(size, 1, 10);
		for (int i = 0; i < array.length; i++) {
			array[i] *= 15;
		}
		return array;
	}
	
	public static int[] sumEveryOther(int[] array) {
		int first = 0;
		for (int i = 0; i < array.length; i += 2) {
			first += array[i];
		}
		
		int second = 0;
		for (int i = 1; i < array.length; i += 2) {
			second += array[i];
		}
		
		int[] a = {first, second};
		return a;
	}
	
	public static void main(String[] args) {
		int cutOff = 5;
		int numTests = 100;
		for (int i = 1; i < cutOff; i++) {
			int[] massages = generateRandomArray(i);
			int maxA = QuestionA.maxMinutes(massages);
			int maxB = QuestionB.maxMinutes(massages);
			int maxC = QuestionC.maxMinutes(massages);
			int maxD = QuestionD.maxMinutes(massages);
			int[] list = sumEveryOther(massages);
			if (maxA != list[0] && maxA != list[1]) {
				System.out.println(AssortedMethods.arrayToString(massages));
				System.out.println(maxA + ", " + maxB + ", " + maxC + ", " + maxD);
			}
			
			if (maxA != maxB || maxB != maxC || maxC != maxD) {
				System.out.println("Error at " + i + ": " + maxA + ", " + maxB + ", " + maxC + ", " + maxD);
			}
		}
		
		for (int i = cutOff; i < numTests; i++) {
			int[] massages = generateRandomArray(i);
			int maxB = QuestionB.maxMinutes(massages);
			int maxC = QuestionC.maxMinutes(massages);
			int maxD = QuestionD.maxMinutes(massages);
			int[] list = sumEveryOther(massages);
			if (maxB != list[0] && maxB != list[1]) {
				System.out.println(AssortedMethods.arrayToString(massages));
				System.out.println(maxB + ", " + maxC + ", " + maxD);
			}			
			if (maxB != maxC || maxC != maxD) {
				System.out.println("Error at " + i + ": " + maxB + ", " + maxC + ", " + maxD);
			}
		}
		System.out.println("All tests have run.");
	}

}
