package Q17_07_Baby_Names;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	private ArrayList<GraphNode> nodes;
	private HashMap<String, GraphNode> map;
	
	public Graph() {
		map = new HashMap<String, GraphNode>();
		nodes = new ArrayList<GraphNode>();
	}
	
	public boolean hasNode(String name) {
		return map.containsKey(name);
	}	
	
	public GraphNode createNode(String name, int freq) {
		if (map.containsKey(name)) { 
			return getNode(name);
		}
		
		GraphNode node = new GraphNode(name, freq);
		nodes.add(node);
		map.put(name, node);
		return node;
	}
	
	private GraphNode getNode(String name) {
		return map.get(name);
	}
	
	public ArrayList<GraphNode> getNodes() {
		return nodes;
	}
	
	public void addEdge(String startName, String endName) {
		GraphNode start = getNode(startName);
		GraphNode end = getNode(endName);
		if (start != null && end != null) {
			start.addNeighbor(end);
			end.addNeighbor(start);
		}
	}
}
