package Q7_06_Jigsaw;

import java.util.LinkedList;
import java.util.Random;

public class Question {

	
	public static Edge createRandomEdge(String code) {
		Random random = new Random();
		Shape type = Shape.INNER;
		if (random.nextBoolean()) {
			type = Shape.OUTER;
		}
		return new Edge(type, code);
	}	
	
	public static Edge[] createEdges(Piece[][] puzzle, int column, int row) {
		String key = column + ":" + row + ":";
		/* Get left edge */
		Edge left = column == 0 ? new Edge(Shape.FLAT, key + "h|e") : puzzle[row][column - 1].getEdgeWithOrientation(Orientation.RIGHT)._createMatchingEdge();
		
		/* Get top edge */
		Edge top = row == 0 ? new Edge(Shape.FLAT, key + "v|e") : puzzle[row - 1][column].getEdgeWithOrientation(Orientation.BOTTOM)._createMatchingEdge();
		
		/* Get right edge */
		Edge right = column == puzzle[row].length - 1 ? new Edge(Shape.FLAT, key + "h|e") : createRandomEdge(key + "h");
		
		/* Get bottom edge */
		Edge bottom = row == puzzle.length - 1 ? new Edge(Shape.FLAT, key + "v|e") : createRandomEdge(key + "v");
		
		Edge[] edges = {left, top, right, bottom};
		return edges;
	}
	
	public static LinkedList<Piece> initializePuzzle(int size) {
		/* Create completed puzzle. */
		Piece[][] puzzle = new Piece[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				Edge[] edges = createEdges(puzzle, column, row);
				puzzle[row][column] = new Piece(edges);
			}
		}

		/* Shuffle and rotate pieces. */
		LinkedList<Piece> pieces = new LinkedList<Piece>();
		Random r = new Random();
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				int rotations = r.nextInt(4);
				Piece piece = puzzle[row][column];
				piece.rotateEdgesBy(rotations);
				int index = pieces.size() == 0 ? 0 : r.nextInt(pieces.size());
				pieces.add(index, piece);
			}
		}
		
		return pieces;
	}	
	
	public static String solutionToString(Piece[][] solution) {
		StringBuilder sb = new StringBuilder();
		for (int h = 0; h < solution.length; h++) {
			for (int w = 0; w < solution[h].length; w++) {
				Piece p = solution[h][w];
				if (p == null) {
					sb.append("null");
				}
				else {
					sb.append(p.toString());
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}	
	
	/* Used for testing. Check if puzzle is solved. */	
	public static boolean validate(Piece[][] solution) {
		if (solution == null) return false;
		for (int r = 0; r < solution.length; r++) {
			for (int c = 0; c < solution[r].length; c++) {
				Piece piece = solution[r][c];
				if (piece == null) return false;
				if (c > 0) { /* match left */
					Piece left = solution[r][c-1];
					if (!left.getEdgeWithOrientation(Orientation.RIGHT).fitsWith(piece.getEdgeWithOrientation(Orientation.LEFT))) {
						return false;
					}
				}
				if (c < solution[r].length - 1) { /* match right */
					Piece right = solution[r][c+1];
					if (!right.getEdgeWithOrientation(Orientation.LEFT).fitsWith(piece.getEdgeWithOrientation(Orientation.RIGHT))) {
						return false;
					}					
				}
				if (r > 0) { /* match top */
					Piece top = solution[r-1][c];
					if (!top.getEdgeWithOrientation(Orientation.BOTTOM).fitsWith(piece.getEdgeWithOrientation(Orientation.TOP))) {
						return false;
					}
				}
				if (r < solution.length - 1) { /* match bottom */
					Piece bottom = solution[r+1][c];
					if (!bottom.getEdgeWithOrientation(Orientation.TOP).fitsWith(piece.getEdgeWithOrientation(Orientation.BOTTOM))) {
						return false;
					}					
				}
			}
		}
		return true;
	}
	
	public static boolean testSize(int size) {
		LinkedList<Piece> pieces = initializePuzzle(size);
		Puzzle puzzle = new Puzzle(size, pieces);
		puzzle.solve();
		Piece[][] solution = puzzle.getCurrentSolution();
		System.out.println(solutionToString(solution));
		boolean result = validate(solution);
		System.out.println(result);
		return result;
	}
	
	
	public static void main(String[] args) {
		for (int size = 1; size < 10; size++) {
			if (!testSize(size)) {
				System.out.println("ERROR: " + size);
			}
		}
		
	}

}
