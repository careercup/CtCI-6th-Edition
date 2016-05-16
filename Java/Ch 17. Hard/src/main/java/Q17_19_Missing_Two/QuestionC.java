package Q17_19_Missing_Two;

public class QuestionC {
	public static int squareSumToN(int n, int power) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += (int) Math.pow(i, power);
		}
		return sum;
	}
	
	public static int[] solveEquation(int r1, int r2) {
		/* ax^2 + bx + c 
		 * -->
		 * x = [-b +- sqrt(b^2 - 4ac)] / 2a
		 * In this case, it has to be a + not a -
		 * 
		 */
		int a = 2;
		int b = -2 * r1;
		int c = r1 * r1 - r2;
		
		double part1 = -1 * b;
		double part2 = Math.sqrt(b*b - 4 * a * c);
		double part3 = 2 * a;
		
		
		int solutionX = (int) ((part1 + part2) / part3);
		int solutionY = r1 - solutionX;
		
		int solutionX2 = (int) ((part1 - part2) / part3);
		int solutionY2 = r1 - solutionX2;
		
		System.out.println("Alternate: (" + solutionX2 + ", " + solutionY2 + ")");
		
		int[] solution = {solutionX, solutionY};
		return solution;
	}
	
	public static int[] missingTwo(int[] array) {
		int max_value = array.length + 2;
		int rem_square = squareSumToN(max_value, 2);
		int rem_one = max_value * (max_value + 1) / 2;
		
		for (int i = 0; i < array.length; i++) {
			rem_square -= array[i] * array[i];
			rem_one -= array[i];
		}
		
		return solveEquation(rem_one, rem_square);
	}
	
	public static void main(String[] args) {
		int max = 100;
		for (int x = 1; x < max; x++) {
			for (int y = 1; y < max; y++) {
				if (x != y) {
					int len = max - 2;
					int count = 0;
					int[] array = new int[len];
					for (int i = 1; i <= max; i++) {
						if (i != x && i != y) {
							array[count] = i;
							count++;
						}
					}
					int[] solution = missingTwo(array);
					
					if ((solution[0] == x && solution[1] == y) ||
						(solution[1] == x && solution[0] == y)) {	
						System.out.println("Success: " + solution[0] + ", " + solution[1]);
					} else {
						System.out.println("Error: " + x + ", " + y + " | " + solution[0] + ", " + solution[1]);
					}
				}
			}
		}
	}

}
