package Q5_04_Next_Number;

public class Tester {
	public static void binPrint(int i) {
		System.out.println(i + ": " + Integer.toBinaryString(i));
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			int p1 = QuestionA.getPrevSlow(i);
			int p2 = QuestionB.getPrev(i);
			int p3 = QuestionC.getPrevArith(i);
			int p4 = QuestionD.getPrev(i);

			int n1 = QuestionA.getNextSlow(i);
			int n2 = QuestionB.getNext(i);
			int n3 = QuestionC.getNextArith(i);
			int n4 = QuestionD.getNext(i);

			if (p1 != p2 || p2 != p3 || p3 != p4 || n1 != n2 || n2 != n3 || n3 != n4) {
				binPrint(i);

				binPrint(p1);
				binPrint(p2);
				binPrint(p3);
				binPrint(p4);

				binPrint(n1);
				binPrint(n2);
				binPrint(n3);
				binPrint(n4);

				System.out.println("");
				break;
			}
		}
		System.out.println("Done!");
	}
}
