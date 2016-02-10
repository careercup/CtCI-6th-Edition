package Q17_22_Word_Transformer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFSData {
	public Queue<PathNode> toVisit = new LinkedList<PathNode>();
	public Map<String, PathNode> visited = new HashMap<String, PathNode>();

	public BFSData(String root) {
		PathNode sourcePath = new PathNode(root, null);
		toVisit.add(sourcePath);
		visited.put(root, sourcePath);	
	}
	
	public boolean isFinished() {
		return toVisit.isEmpty();
	}
}

