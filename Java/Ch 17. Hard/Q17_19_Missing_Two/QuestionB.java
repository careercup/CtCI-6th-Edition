package Q17_19_Missing_Two;

public class QuestionB {
	public static int missingOne(int[] array) {
		int max_value = array.length + 1;
		int remainder = max_value * (max_value + 1) / 2;
		
		for (int i = 0; i < array.length; i++) {
			remainder -= array[i];
		}
		return remainder;
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
