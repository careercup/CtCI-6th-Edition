package Q10_08_Find_Duplicates;

import CtCILibrary.AssortedMethods;

public class Question {

	public static void checkDuplicates(int[] array) {
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			int num0 = num - 1; // bitset starts at 0, numbers start at 1
			if (bs.get(num0)) { 
				System.out.println(num);
			} else {
				bs.set(num0);				
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = AssortedMethods.randomArray(30, 1, 30);
		System.out.println(AssortedMethods.arrayToString(array));
		checkDuplicates(array);
	}

}
