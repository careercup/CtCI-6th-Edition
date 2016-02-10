package Q8_02_Robot_in_a_Grid;

import CtCILibrary.AssortedMethods;

import java.util.List;

public class Tester {
	public static void main(String[] args) {
		int size = 5;
		boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 70);
		
		AssortedMethods.printMatrix(maze);

		List<Point> pathA = QuestionA.getPath(maze);
		List<Point> pathB = QuestionB.getPath(maze);
		if (pathA != null) {
			System.out.println(pathA);
		} else {
			System.out.println("No path found.");
		}
		
		if (pathB != null) {
			System.out.println(pathB);
		} else {
			System.out.println("No path found.");
		}		
	}
}
