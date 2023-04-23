package Q3_03_Stack_of_Plates;

public class QuestionA {
	public static void main(String[] args) {
		int capacity_per_substack = 5;
		SetOfStacks2 set = new SetOfStacks2(capacity_per_substack);
		for (int i = 0; i < 34; i++) {
			set.push(i);
		}
		for (int i = 0; i < 35; i++) {
			System.out.println("Popped " + set.pop());
		}		
	}
}
