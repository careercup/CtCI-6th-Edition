package Q17_07_Baby_Names;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNode {
	private List<GraphNode> neighbors;
	private Map<String, GraphNode> map;
	private String name;
	private int frequency;
	private boolean visited = false;
	
	public GraphNode(String nm, int freq) {
		name = nm;
		frequency = freq;
		neighbors = new ArrayList<>();
		map = new HashMap<>();
	}

	public String getName() {
		return name;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public boolean addNeighbor(GraphNode node) {
		if (map.containsKey(node.getName())) {
			return false;
		}
		neighbors.add(node);
		map.put(node.getName(), node);
		return true;
	}

	public List<GraphNode> getNeighbors() {
		return neighbors;
	}
		
	public boolean isVisited() {
		return visited;
	}
	
	public void setIsVisited(boolean v) {
		visited = v;
	}
}
