package Q8_13_Stack_of_Boxes;

import java.util.ArrayList;
import java.util.Random;

public class Tester {

	public static Box createRandomBox() {
		Random r = new Random();
		return new Box(r.nextInt(100), r.nextInt(100), r.nextInt(100));
	}
	
	public static void main(String[] args) {
		ArrayList<Box> boxes1 = new ArrayList<Box>();
		ArrayList<Box> boxes2 = new ArrayList<Box>();
		ArrayList<Box> boxes3 = new ArrayList<Box>();
		for (int i = 0; i < 200; i++) {
			Box b = createRandomBox();
			boxes1.add(b);
			boxes2.add(b);
			boxes3.add(b);
		}
		
		int height1 = QuestionA.createStack(boxes1);
		int height2 = QuestionB.createStack(boxes2);
		int height3 = QuestionB.createStack(boxes3);
		System.out.println(height1 + ", " + height2 + ", " + height3);
	}

}
