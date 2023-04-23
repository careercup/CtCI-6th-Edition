package Q17_06_Count_of_2s;

public class QuestionBrute {

	public static int numberOf2s(int n) {
		int count = 0;
		while (n > 0) {
			if (n % 10 == 2) {
				count++;
			}
			n = n / 10;
		}
		return count;
	}
	
	public static int numberOf2sInRange(int n) {
		int count = 0;
		for (int i = 2; i <= n; i++) { // Might as well start at 2
			count += numberOf2s(i);
		}
		return count;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			int v = numberOf2sInRange(i);
			System.out.println("Between 0 and " + i + ": " + v);
		}		
	}
}
