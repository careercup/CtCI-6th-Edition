package Q7_06_Jigsaw;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Puzzle {
	private List<Piece> pieces; /* Remaining pieces left to put away. */
	private Piece[][] solution;
	private int size;

	public Puzzle(int size, List<Piece> pieces) {
		this.pieces = pieces;
		this.size = size;
	}
	
	/* Group pieces into border pieces (including corners) and inside pieces. */
	public void groupPieces(Collection<Piece> cornerPieces, Collection<Piece> borderPieces, Collection<Piece> insidePieces) {
		for (Piece p : pieces) {
			if (p.isCorner()) {
				cornerPieces.add(p);
			} else if (p.isBorder()) {
				borderPieces.add(p);
			} else {
				insidePieces.add(p);
			}
		}
	}
	
	/* Orient this corner piece so that its flat edges are on the top and left. */ 
	public void orientTopLeftCorner(Piece piece) {
		if (!piece.isCorner()) return;
		
		Orientation[] orientations = Orientation.values();
		for (int i = 0; i < orientations.length; i++) {
			Edge current = piece.getEdgeWithOrientation(orientations[i]);
			Edge next = piece.getEdgeWithOrientation(orientations[(i + 1) % orientations.length]);
			if (current.getShape() == Shape.FLAT && next.getShape() == Shape.FLAT) {
				piece.setEdgeAsOrientation(current, Orientation.LEFT);
				return;
			}	
		}
	}
	
	/* Bounds check. Check if this index is on a border (0 or size - 1) */
	public boolean isBorderIndex(int location) {
		return location == 0 || location == size - 1;
	}
	
	/* Given a list of pieces, check if any have an edge that matches this piece. Return the edge*/
	private Edge getMatchingEdge(Edge targetEdge, Iterable<Piece> pieces) {
		for (Piece piece : pieces) {
			Edge matchingEdge = piece.getMatchingEdge(targetEdge);
			if (matchingEdge != null) {
				return matchingEdge;
			}
		}	
		return null;
	}

	/* Put the edge/piece into the solution, turn it appropriately, and remove from list. */
	private void setEdgeInSolution(Collection<Piece> pieces, Edge edge, int row, int column, Orientation orientation) {
		Piece piece = edge.getParentPiece();
		piece.setEdgeAsOrientation(edge, orientation);
		pieces.remove(piece);
		solution[row][column] = piece;
	}
	
	/* Return the list where a piece with this index would be found. */
	private Queue<Piece> getPieceListToSearch(Queue<Piece> cornerPieces, Queue<Piece> borderPieces, Queue<Piece> insidePieces, int row, int column) {
		if (isBorderIndex(row) && isBorderIndex(column)) {
			return cornerPieces;
		} else if (isBorderIndex(row) || isBorderIndex(column)) {
			return borderPieces;
		} else {
			return insidePieces;
		}
	}
	
	/* Find the matching piece within piecesToSearch and insert it at row, column. */
	private boolean fitNextEdge(Queue<Piece> piecesToSearch, int row, int column) {
		if (row == 0 && column == 0) {
			Piece p = piecesToSearch.remove();
			orientTopLeftCorner(p);
			solution[0][0] = p;
		} else {
			/* Get the right edge and list to match. */
			Piece pieceToMatch = column == 0 ? solution[row - 1][0] : solution[row][column - 1];
			Orientation orientationToMatch = column == 0 ? Orientation.BOTTOM : Orientation.RIGHT;
			Edge edgeToMatch = pieceToMatch.getEdgeWithOrientation(orientationToMatch);
			
			/* Get matching edge. */
			Edge edge = getMatchingEdge(edgeToMatch, piecesToSearch);
			if (edge == null) return false; // Can't solve
			
			Orientation orientation = orientationToMatch.getOpposite();
			setEdgeInSolution(piecesToSearch, edge, row, column, orientation);		
		}
		return true;
	}
	
	public boolean solve() {
		/* Group pieces. */
		Queue<Piece> cornerPieces = new LinkedList<Piece>();
		Queue<Piece> borderPieces = new LinkedList<Piece>();
		Queue<Piece> insidePieces = new LinkedList<Piece>();
		groupPieces(cornerPieces, borderPieces, insidePieces);
		
		/* Walk through puzzle, finding the piece that joins the previous one. */
		solution = new Piece[size][size];	
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				Queue<Piece> piecesToSearch = getPieceListToSearch(cornerPieces, borderPieces, insidePieces, row, column);
				if (!fitNextEdge(piecesToSearch, row, column)) {
					return false;
				}
			}
		}
		
		return true;
	}	
	
	public Piece[][] getCurrentSolution() {
		return solution;
	}
}
