package Q5_04_Next_Number;

public class Tester {
	public static void binPrint(int i) {
		System.out.println(i + ": " + Integer.toBinaryString(i));		
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 200; i++) {
			int p1 = QuestionA.getPrevSlow(i);
			int p2 = QuestionB.getPrev(i);
			int p3 = QuestionC.getPrevArith(i);
			
			int n1 = QuestionA.getNextSlow(i);
			int n2 = QuestionB.getNext(i);
			int n3 = QuestionC.getNextArith(i);
			
			if (p1 != p2 || p2 != p3 || n1 != n2 || n2 != n3) {
				binPrint(i);
				binPrint(p1);
				binPrint(p2);
				binPrint(p3);
				binPrint(n1);
				binPrint(n2);
				binPrint(n3);
				System.out.println("");
				break;
			}			
		}
		System.out.println("Done!");
	}

}
