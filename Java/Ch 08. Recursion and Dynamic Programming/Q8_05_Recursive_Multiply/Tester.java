package Q8_05_Recursive_Multiply;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 1000;
		int[][] victory = new int[3][3];
		int ties = 0;
		for (int a = 0; a < max; a++) {
			for (int b = 0; b < max; b++) {
				int prodA = QuestionA.minProduct(a,  b);
				int prodB = QuestionB.minProduct(a,  b);
				int prodC = QuestionC.minProduct(a, b);
				
				int product = a * b;
				
				int counterA = QuestionA.counter;
				int counterB = QuestionB.counter;
				int counterC = QuestionC.counter;

				QuestionA.counter = 0;
				QuestionB.counter = 0;
				QuestionC.counter = 0;
				
				if (prodA != product || prodB != product || prodC != product) {
					System.out.println("Failure: " + a + " * " + b + " = " + product + " instead of (" + prodA + ", " + prodB + ", " + prodC + ")");
					break;
				} else {
					String tuple = "(" + counterA + ", " + counterB + ", " + counterC + ")";
					String prods = "\n" + a + "*" + b + " ";
					if (counterA < counterB && counterB < counterC) {
						System.out.print(prods + " Winner: A. " + tuple);
						victory[0][1]++;
					} else if (counterA < counterC && counterC < counterA) {
						System.out.print(prods + " Winner: A. " + tuple);
						victory[0][2]++;
					} else if (counterB < counterA && counterA < counterC) {
						//System.out.print(prods + " Winner: B. " + tuple);
						victory[1][0]++;
					} else if (counterB < counterC && counterC < counterA) {
						//System.out.print(prods + " Winner: B. " + tuple);
						victory[1][2]++;
					} else if (counterC < counterA && counterA < counterB) {
						//System.out.print(prods + " Winner: C. " + tuple);
						victory[2][0]++;
					} else if (counterC < counterB && counterB < counterA) {
						//System.out.print(prods + " Winner: C. " + tuple);
						victory[2][1]++;
					} else { // Tie
						System.out.print(prods + " Tie. " + tuple);
						ties++;
					}
				}
			}
		}

		System.out.println();
		System.out.println("A, B: " + victory[0][1]);
		System.out.println("A, C: " + victory[0][2]);
		System.out.println("B, A: " + victory[1][0]);
		System.out.println("B, C: " + victory[1][2]);
		System.out.println("C, A: " + victory[2][0]);
		System.out.println("C, B: " + victory[2][1]);
		System.out.println("Partial/Full Tie: " + ties);
	}

}
