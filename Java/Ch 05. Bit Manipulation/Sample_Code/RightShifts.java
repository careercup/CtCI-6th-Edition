package Sample_Code;

import CtCILibrary.AssortedMethods;

public class RightShifts {
	public static int repeatedArithmeticShift(int x, int count) {
		for (int i = 0; i < count; i++) {
			x >>= 1; // Arithmetic shift by 1
		}
		return x;
	}
	
	public static int repeatedLogicalShift(int x, int count) {
		for (int i = 0; i < count; i++) {
			x >>>= 1; // Logical shift by 1
		}
		return x;
	}	
	
	public static void main(String[] args) {
		for (int i = 8; i >= -8; i--) {
			System.out.println(AssortedMethods.toFullBinaryString(i) + ": " + i);
		}
		
		int x = -93242;
		int resultArithmetic = repeatedArithmeticShift(x, 40);
		int resultLogical = repeatedLogicalShift(x, 40);
		System.out.println(AssortedMethods.toFullBinaryString(resultArithmetic) + ": " + resultArithmetic);
		System.out.println(AssortedMethods.toFullBinaryString(resultLogical) + ": " + resultLogical);
	}

}
