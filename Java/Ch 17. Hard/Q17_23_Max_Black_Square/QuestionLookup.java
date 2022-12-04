package Q17_23_Max_Black_Square;

import CtCILibrary.AssortedMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class QuestionLookup {
	private static class Cell {
		public int row;
		public int column;
		public boolean isZero;
		public int zerosRight;
		public int zerosBelow;
		public int zerosLeft;
		public int zerosAbove;
		public int minRightAndBelow;
		public int minLeftAndAbove;
	}
	
	/* 1D interval
	 * (needed for a subtask of finding longest intersecting intervals) */
	private static class Interval {
		public int start;
		public int end;
		public int length;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
			this.length = end - start + 1;
		}
	}
	
	private static Subsquare maxSquare(Subsquare a, Subsquare b) {
		return a == null ? b : b == null ? a : a.size < b.size ? b : a;
	}
	
	private static Interval maxInterval(Interval a, Interval b) {
		return a == null ? b : b == null ? a : a.length < b.length ? b : a;
	}
	
	public static Subsquare findSquare(int[][] matrix) {
		Cell[][] cells = createCells(matrix);
		countZerosRightAndBelow(cells);
		countZerosLeftAndAbove(cells);
		return findSquareAmongDiagonals(cells);
	}
	
	private static Cell[][] createCells(int[][] matrix) {
		int size = matrix.length;
		Cell[][] cells = new Cell[size][size];
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				Cell cell = cells[r][c] = new Cell();
				cell.row = r;
				cell.column = c;
				cell.isZero = matrix[r][c] == 0;
			}
		}
		return cells;
	}
	
	private static void countZerosRightAndBelow(Cell[][] cells) {
		int size = cells.length;
		for (int r = size - 1; r >= 0; r--) {
			for (int c = size - 1; c >= 0; c--) {
				Cell cell = cells[r][c];
				if (!cell.isZero) {
					continue;
				}
				cell.zerosRight = (c + 1 < size ? cells[r][c + 1].zerosRight : 0) + 1;
				cell.zerosBelow = (r + 1 < size ? cells[r + 1][c].zerosBelow : 0) + 1;
				cell.minRightAndBelow = Math.min(cell.zerosRight, cell.zerosBelow);
			}
		}
	}
	
	private static void countZerosLeftAndAbove(Cell[][] cells) {
		int size = cells.length;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				Cell cell = cells[r][c];
				if (!cell.isZero) {
					continue;
				}
				cell.zerosLeft = (c > 0 ? cells[r][c - 1].zerosLeft : 0) + 1;
				cell.zerosAbove = (r > 0 ? cells[r - 1][c].zerosAbove : 0) + 1;
				cell.minLeftAndAbove = Math.min(cell.zerosLeft, cell.zerosAbove);
			}
		}
	}
	
	private static Subsquare findSquareAmongDiagonals(Cell[][] cells) {
		int size = cells.length;
		Subsquare best = null;
		/* Loop through the diagonals of the matrix.
		 * The diagonal 0 goes from top left corner to the bottom right corner.
		 * It's the longest diagonal. Its length equals to "size".
		 * Diagonals with negative numbers are above, positive below.
		 * E.g., the last diagonal with maximum number is located at the
		 * bottom left corner. Its length is 1. */
		for (int diagonal = -size + 1; diagonal < size; diagonal++) {
			Cell[] diagonalCells = extractDiagonal(cells, diagonal);
			Subsquare subsquare = findSquareOnDiagonal(diagonalCells);
			best = maxSquare(best, subsquare);
		}
		return best;
	}
	
	/* Copy a diagonal of a square to a separate one-dimensional array */
	private static Cell[] extractDiagonal(Cell[][] cells, int diagonal) {
		int size = cells.length;
		int diagonalLength = size - Math.abs(diagonal);
		Cell[] diagonalCells = new Cell[diagonalLength];
		for (int position = 0; position < diagonalLength; position++) {
			int r = diagonal < 0 ? position : position + diagonal;
			int c = diagonal < 0 ? position - diagonal : position;
			Cell cell = cells[r][c];
			diagonalCells[position] = cell;
		}
		return diagonalCells;
	}
	
	private static Subsquare findSquareOnDiagonal(Cell[] diagonalCells) {
		Interval[] leftStarts = getDiagonalLeftIntervals(diagonalCells);
		Interval[] rightEnds = getDiagonalRightIntervals(diagonalCells);
		Interval intersection = findLongestIntersection(leftStarts, rightEnds);
		if (intersection == null) {
			return null;
		}
		Cell topLeftCorner = diagonalCells[intersection.start];
		return new Subsquare(topLeftCorner.row, topLeftCorner.column, intersection.length);
	}
	
	private static Interval[] getDiagonalLeftIntervals(Cell[] diagonalCells) {
		Interval[] intervals = new Interval[diagonalCells.length];
		for (int start = 0; start < intervals.length; start++) {
			int length = diagonalCells[start].minRightAndBelow;
			int end = start + length - 1;
			intervals[start] = new Interval(start, end);
		}
		return intervals;
	}
	
	private static Interval[] getDiagonalRightIntervals(Cell[] diagonalCells) {
		Interval[] intervals = new Interval[diagonalCells.length];
		for (int end = 0; end < intervals.length; end++) {
			int length = diagonalCells[end].minLeftAndAbove;
			int start = end - length + 1;
			intervals[end] = new Interval(start, end);
		}
		return intervals;
	}
	
	/* Turn array where index is the end of an interval
	 * into array where index is the start of intervals and value is a list of their ends.
	 * A list is needed because multiple intervals can start at the same position. */
	private static List[] getStartToEndMap(Interval[] intervalEnds) {
		List[] intervalStarts = new List[intervalEnds.length];
		for (Interval interval : intervalEnds) {
			intervalStarts[interval.end] = new ArrayList<>();
			if (interval.length != 0) {
				intervalStarts[interval.start].add(interval.end);
			}
		}
		return intervalStarts;
	}
	
	/* Find longest intersection {start, end} of left and right intervals such that
	 * end - rightEnds[end] + 1 <= start <= end <= start + leftStarts[start] - 1
	 * Equivalently: right.start <= left.start <= right.end <= left.end */
	private static Interval findLongestIntersection(Interval[] leftStarts, Interval[] rightEnds) {
		List[] rightStartToEndMap = getStartToEndMap(rightEnds);
		Interval longest = null;
		NavigableSet<Integer> openedRightIntervals = new TreeSet<>();
		for (Interval left : leftStarts) {
			openedRightIntervals.addAll(rightStartToEndMap[left.start]);
			Integer rightEnd = left.length == 0 ? null : openedRightIntervals.floor(left.end);
			Interval intersection = rightEnd == null ? null : new Interval(left.start, rightEnd);
			longest = maxInterval(longest, intersection);
			openedRightIntervals.remove(left.start);
		}
		return longest;
	}
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(7, 7, 0, 1);
		AssortedMethods.printMatrix(matrix);
		Subsquare square = findSquare(matrix);
		if (square == null) {
			System.out.println("no squares found");
		} else {
			square.print();
		}
	}
}