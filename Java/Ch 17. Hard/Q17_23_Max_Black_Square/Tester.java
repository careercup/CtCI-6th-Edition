package Q17_23_Max_Black_Square;

import CtCILibrary.AssortedMethods;
import java.util.ArrayList;
import java.util.List;

public class Tester {
	private static void throwSquaresDiffer(int[][] matrix, Subsquare expectedMaxSquare, Subsquare actualMaxSquare) {
		System.out.println("wrong size");
		AssortedMethods.printMatrix(matrix);
		System.out.println("expected square:");
		expectedMaxSquare.print();
		System.out.println("actual square:");
		actualMaxSquare.print();
		throw new AssertionError("wrong size");
	}
	
	private static List<Subsquare> findSquareAllMethods(int[][] matrix) {
		List<Subsquare> maxSquares = new ArrayList<Subsquare>();
		// comment out slow versions to speed up the test
		maxSquares.add(Question.findSquare(matrix));
		maxSquares.add(QuestionEff.findSquare(matrix));
		maxSquares.add(QuestionLookup.findSquare(matrix));
		return maxSquares;
	}
	
	private static void checkMatrix(int[][] matrix, Subsquare expected) {
		List<Subsquare> maxSquares = findSquareAllMethods(matrix);
		for (Subsquare square : maxSquares) {
			if (expected == null ? square == null : expected.equals(square)) {
				continue;
			}
			throwSquaresDiffer(matrix, expected, square);
		}
	}
	
	private static void testSquareInsideCorner() {
		int[][] matrix = {
			{0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1},
			{0, 1, 0, 0, 0},
			{0, 1, 0, 1, 0},
			{0, 1, 0, 0, 0},
		};
		Subsquare expected = new Subsquare(2, 2, 3);
		checkMatrix(matrix, expected);
	}
	
	private static void testSquare() {
		int[][] matrix = {
			{0, 0, 0, 0, 1, 1, 1, 1},
			{0, 0, 0, 0, 0, 0, 1, 1},
			{0, 0, 1, 1, 1, 1, 1, 1},
			{0, 0, 1, 0, 0, 1, 1, 1},
			{1, 0, 1, 0, 0, 0, 0, 1},
			{1, 0, 1, 1, 0, 1, 0, 1},
			{1, 1, 1, 1, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 0, 1},
		};
		Subsquare expected = new Subsquare(4, 4, 3);
		checkMatrix(matrix, expected);
	}
	
	private static void testLongerCornerInsideShorterOne() {
		int[][] matrix = {
			{0, 0, 0, 0, 1, 1, 1, 1},
			{0, 0, 0, 0, 0, 0, 1, 1},
			{0, 0, 1, 0, 1, 1, 1, 1},
			{0, 0, 0, 0, 0, 1, 1, 1},
			{1, 0, 1, 0, 0, 0, 0, 1},
			{1, 0, 1, 1, 0, 1, 0, 1},
			{1, 1, 1, 1, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 0, 1},
		};
		Subsquare expected = new Subsquare(0, 0, 4);
		checkMatrix(matrix, expected);
	}
	
	private static void testAllBlack() {
		int[][] matrix = AssortedMethods.randomMatrix(10, 10, 0, 0);
		Subsquare expected = new Subsquare(0, 0, 10);
		checkMatrix(matrix, expected);
	}
	
	private static void testAllWhite() {
		int[][] matrix = AssortedMethods.randomMatrix(10, 10, 1, 1);
		Subsquare expected = null;
		checkMatrix(matrix, expected);
	}
	
	private static void testComparison() {
		for (int size = 0; size <= 1000; size += 10) {
			int[][] matrix = AssortedMethods.randomMatrix(size, size, 0, 1);
			List<Subsquare> maxSquares = findSquareAllMethods(matrix);
			Subsquare expectedMaxSquare = maxSquares.get(0);
			int expectedMaxSize = expectedMaxSquare == null ? 0 : expectedMaxSquare.size;
			System.out.println("size = "+size);
			if (expectedMaxSquare == null) {
				System.out.println("no square found");
			} else {
				expectedMaxSquare.print();
			}
			for (int i = 1; i < maxSquares.size(); i++) {
				Subsquare actualMaxSquare = maxSquares.get(i);
				int actualMaxSize = actualMaxSquare == null ? 0 : actualMaxSquare.size;
				if (actualMaxSize == expectedMaxSize) {
					continue;
				}
				throwSquaresDiffer(matrix, expectedMaxSquare, actualMaxSquare);
			}
		}
	}
	
	public static void main(String[] args) {
		testAllBlack();
		testAllWhite();
		testLongerCornerInsideShorterOne();
		testSquare();
		testSquareInsideCorner();
		testComparison();
	}
}