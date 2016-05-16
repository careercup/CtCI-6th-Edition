package Q8_05_Recursive_Multiply;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 1000;
		int counterA = 0, counterB = 0, counterC = 0, counterD = 0;
		
		for (int a = 0; a < max; a++) {
			for (int b = 0; b < max; b++) {
				int prodA = QuestionA.minProduct(a, b);
				int prodB = QuestionB.minProduct(a, b);
				int prodC = QuestionC.minProduct(a, b);
				int prodD = QuestionD.minProduct(a, b);
				
				int product = a * b;
				
				counterA += QuestionA.counter;
				counterB += QuestionB.counter;
				counterC += QuestionC.counter;
				counterD += QuestionD.counter;

				QuestionA.counter = 0;
				QuestionB.counter = 0;
				QuestionC.counter = 0;
				QuestionD.counter = 0;
				
				if (prodA != product || prodB != product || prodC != product || prodD != product) {
					System.out.println("Failure: " + a + " * " + b + " = " + product + " instead of (" + prodA + ", " + prodB + ", " + prodC + ", " + prodD + ")");
					break;
				} 
			}
		}

		System.out.println();
		System.out.println("A: " + counterA);
		System.out.println("B: " + counterB);
		System.out.println("C: " + counterC);
		System.out.println("D: " + counterD);
	}

}
