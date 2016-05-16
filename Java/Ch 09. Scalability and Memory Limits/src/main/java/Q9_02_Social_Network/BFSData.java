package Q9_02_Social_Network;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFSData {
	public Queue<PathNode> toVisit = new LinkedList<PathNode>();
	public HashMap<Integer, PathNode> visited = new HashMap<Integer, PathNode>();

	public BFSData(Person root) {
		PathNode sourcePath = new PathNode(root, null);
		toVisit.add(sourcePath);
		visited.put(root.getID(), sourcePath);	
	}
	
	public boolean isFinished() {
		return toVisit.isEmpty();
	}
}
