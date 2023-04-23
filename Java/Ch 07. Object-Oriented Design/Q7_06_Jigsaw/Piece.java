package Q7_06_Jigsaw;

import java.util.HashMap;
import java.util.Map.Entry;

public class Piece {
	private final static int NUMBER_OF_EDGES = 4;
	private HashMap<Orientation, Edge> edges = new HashMap<Orientation, Edge>();
	
	public Piece(Edge[] edgeList) {		
		Orientation[] orientations = Orientation.values();
		for (int i = 0; i < edgeList.length; i++) {
			Edge edge = edgeList[i];
			edge.setParentPiece(this);	
			edges.put(orientations[i], edge);
		}
	}
	
	/* Set this edge in the appropriate orientation, rotating the piece as necessary. */
	public void setEdgeAsOrientation(Edge edge, Orientation orientation) {
		Orientation currentOrientation = getOrientation(edge);
		rotateEdgesBy(orientation.ordinal() - currentOrientation.ordinal());
	}
	
	/* Return the current orientation of the edge. */
	private Orientation getOrientation(Edge edge) {
		for (Entry<Orientation, Edge> entry : edges.entrySet()) {
			if (entry.getValue() == edge) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	/* Rotate edges by "numberRotations". */
	public void rotateEdgesBy(int numberRotations) {
		Orientation[] orientations = Orientation.values();
		HashMap<Orientation, Edge> rotated = new HashMap<Orientation, Edge>();
		
		numberRotations = numberRotations % NUMBER_OF_EDGES;
		if (numberRotations < 0) numberRotations += NUMBER_OF_EDGES;
		
		for (int i = 0; i < orientations.length; i++) {
			Orientation oldOrientation = orientations[(i - numberRotations + NUMBER_OF_EDGES) % NUMBER_OF_EDGES];
			Orientation newOrientation = orientations[i];
			rotated.put(newOrientation, edges.get(oldOrientation));
		}		
		edges = rotated;
	}
	
	/* Check if this piece is a corner piece. */
	public boolean isCorner() {
		Orientation[] orientations = Orientation.values();
		for (int i = 0; i < orientations.length; i++) {
			Shape current = edges.get(orientations[i]).getShape();
			Shape next = edges.get(orientations[(i + 1) % NUMBER_OF_EDGES]).getShape();
			if (current == Shape.FLAT && next == Shape.FLAT) {
				return true;
			}
		}
		return false;
	}
	
	/* Check if this piece has a border edge. */
	public boolean isBorder() {
		Orientation[] orientations = Orientation.values();
		for (int i = 0; i < orientations.length; i++) {
			if (edges.get(orientations[i]).getShape() == Shape.FLAT) {
				return true;
			}
		}
		return false;
	}
	
	/* Get edge at this orientation. */
	public Edge getEdgeWithOrientation(Orientation orientation) {
		return edges.get(orientation);
	}	
	
	/* Return the edge that matches targetEdge. Returns null if there is no match. */
	public Edge getMatchingEdge(Edge targetEdge) {
		for (Edge e : edges.values()) {
			if (targetEdge.fitsWith(e)) {
				return e;
			}
		}
		return null;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Orientation[] orientations = Orientation.values();
		for (Orientation o : orientations) {
			sb.append(edges.get(o).toString() + ",");
		}
		return "[" + sb.toString() + "]";
	}
}
