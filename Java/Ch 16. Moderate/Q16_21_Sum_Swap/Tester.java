package Q16_21_Sum_Swap;

import CtCILibrary.AssortedMethods;

public class Tester {
	
	public static boolean isEquivalent(int[] a, int[] b, int[] c, int[] d) {
		if (a == null || b == null || c == null || d == null) {
			return a == null && b == null && c == null && d == null;
		}
		return difference(a) == difference(b) && difference(a) == difference(c) && difference(a) == difference(d);
	}
	
	public static int difference(int[] a) {
		if (a.length != 2) {
			return -1;
		}
		return a[0] - a[1];
	}
	
	public static String arrayToString(int[] array) {
		StringBuffer sb = new StringBuffer();
		for (int a : array) {
			sb.append(a + " ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int count = 0;
		int max = 100;
		while (count < max) {
			int[] array1 = AssortedMethods.randomArray(10, -10,  10);
			int[] array2 = AssortedMethods.randomArray(10, -10,  10);;
			int[] swapsA = QuestionA.findSwapValues(array1, array2);
			int[] swapsB = QuestionB.findSwapValues(array1, array2);
			int[] swapsC = QuestionC.findSwapValues(array1, array2);
			int[] swapsD = QuestionD.findSwapValues(array1, array2);
			
			if (swapsA != null || swapsB != null || swapsC != null || swapsD != null) {
				count++;
			}
			
			if (!isEquivalent(swapsA, swapsB, swapsC, swapsD)) {
				System.out.println("Error");
				System.out.println(AssortedMethods.arrayToString(array1));
				System.out.println(AssortedMethods.arrayToString(array2));
				System.out.println(AssortedMethods.arrayToString(swapsA));
				System.out.println(AssortedMethods.arrayToString(swapsB));
				System.out.println(AssortedMethods.arrayToString(swapsC));
				System.out.println(AssortedMethods.arrayToString(swapsD));
				break;
			} else {
				System.out.println("Equivalent.");
				System.out.println(AssortedMethods.arrayToString(array1));
				System.out.println(AssortedMethods.arrayToString(array2));
				System.out.println(AssortedMethods.arrayToString(swapsA));
				System.out.println(AssortedMethods.arrayToString(swapsB));
				System.out.println(AssortedMethods.arrayToString(swapsC));
				System.out.println(AssortedMethods.arrayToString(swapsD));
				System.out.println("\n");
			}
		}
	}

}
