package Q17_09_Kth_Multiple;

import java.util.Queue;
import java.util.LinkedList;

public class QuestionC {
	public static void printQueue(Queue<Integer> q, int x) {
		System.out.print(x + ": ");
		for (Integer a : q) {
			System.out.print(a / x + ", ");
		}
		System.out.println("");
	}
	
	public static int getKthMagicNumber(int k) {
		if (k < 0) {
			return 0;
		}
		int val = 0;
		Queue<Integer> queue3 = new LinkedList<Integer>();
		Queue<Integer> queue5 = new LinkedList<Integer>();
		Queue<Integer> queue7 = new LinkedList<Integer>();
		queue3.add(1);
		for (int i = 0; i <= k; i++) { // Include 0th iteration through kth iteration
			int v3 = queue3.size() > 0 ? queue3.peek() : Integer.MAX_VALUE; 
			int v5 = queue5.size() > 0 ? queue5.peek() : Integer.MAX_VALUE;
			int v7 = queue7.size() > 0 ? queue7.peek() : Integer.MAX_VALUE;
			val = Math.min(v3, Math.min(v5, v7));
			if (val == v3) {
				queue3.remove();
				queue3.add(3 * val);
				queue5.add(5 * val);
			} else if (val == v5) {
				queue5.remove();
				queue5.add(5 * val);
			} else if (val == v7) {
				queue7.remove();
			}
			queue7.add(7 * val);
		}
		return val;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 14; i++) {
			System.out.println(i + " : " + getKthMagicNumber(i));
		}
	}
}
