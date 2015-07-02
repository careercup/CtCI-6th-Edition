package Q17_19_Missing_Two;

import java.math.BigInteger;

public class QuestionA {

	public static BigInteger productToN(int n) {
		BigInteger fullProduct = new BigInteger("1");
		for (int i = 2; i <= n; i++) {
			fullProduct = fullProduct.multiply(new BigInteger(i + ""));
		}
		return fullProduct;
	}
	
	public static int missingOne(int[] array) {
		BigInteger fullProduct = productToN(array.length + 1);
		
		BigInteger actualProduct = new BigInteger("1");
		for (int i = 0; i < array.length; i++) {
			BigInteger value = new BigInteger(array[i] + "");
			actualProduct = actualProduct.multiply(value);
		}
		
		BigInteger missingNumber = fullProduct.divide(actualProduct);
		return Integer.parseInt(missingNumber.toString());
	}
	
	public static void main(String[] args) {
		int max = 100;
		int x = 8;
		int len = max - 1;
		int count = 0;
		int[] array = new int[len];
		for (int i = 1; i <= max; i++) {
			if (i != x) {
				array[count] = i;
				count++;
			}
		}
		System.out.println(x);
		int solution = missingOne(array);
		
		System.out.println(solution);
	}

}
