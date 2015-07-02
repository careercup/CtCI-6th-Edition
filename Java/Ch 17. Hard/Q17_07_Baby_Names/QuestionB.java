package Q17_07_Baby_Names;

import java.util.HashMap;
import java.util.Map.Entry;

public class QuestionB {
	/* Add all names to graph as nodes. */
	public static Graph constructGraph(HashMap<String, Integer> names) {
		Graph graph = new Graph();
		for (Entry<String, Integer> entry : names.entrySet()) {
		    String name = entry.getKey();
		    int frequency = entry.getValue();
		    graph.createNode(name, frequency);
		}
		return graph;
	}
	
	/* Connect synonymous spellings. */
	public static void connectEdges(Graph graph, String[][] synonyms) {
		for (String[] entry : synonyms) {
		    String name1 = entry[0];
		    String name2 = entry[1];
		    graph.addEdge(name1,  name2);
		}
	}
	
	/* Do depth-first search to find the total frequency of this 
	 * component, and mark each node as visited.*/	
	public static int getComponentFrequency(GraphNode node) {
		if (node.isVisited()) {
			return 0;
		}
		node.setIsVisited(true);
		int sum = node.getFrequency();
		for (GraphNode child : node.getNeighbors()) {
			sum += getComponentFrequency(child);
		}
		return sum;
	}
	
	/* Do DFS of each component. If a node has been visited before,
	 * then its component has already been computed. */
	public static HashMap<String, Integer> getTrueFrequencies(Graph graph) {
		HashMap<String, Integer> rootNames = new HashMap<String, Integer>();
		for (GraphNode node : graph.getNodes()) {
			if (!node.isVisited()) {
				int frequency = getComponentFrequency(node);
				String name = node.getName();
				rootNames.put(name, frequency);
			}
		}
		return rootNames;
	}
	
	public static HashMap<String, Integer> trulyMostPopular(HashMap<String, Integer> names, String[][] synonyms) {
		Graph graph = constructGraph(names);
		connectEdges(graph, synonyms);
		HashMap<String, Integer> rootNames = getTrueFrequencies(graph);
		return rootNames;
	}
	
	public static void main(String[] args) {
		HashMap<String, Integer> names = new HashMap<String, Integer>();
		
		names.put("John", 3);
		names.put("Jonathan", 4);
		names.put("Johnny", 5);
		names.put("Chris", 1);
		names.put("Kris", 3);
		names.put("Brian", 2);
		names.put("Bryan", 4);
		names.put("Carleton", 4);
		
		String[][] synonyms = 
			{{"John", "Jonathan"}, 
			 {"Jonathan", "Johnny"}, 
			 {"Chris", "Kris"}, 
			 {"Brian", "Bryan"}};
		
		HashMap<String, Integer> rootNames = trulyMostPopular(names, synonyms);
		for (Entry<String, Integer> entry : rootNames.entrySet()) {
		    String name = entry.getKey();
		    int frequency = entry.getValue();
		    System.out.println(name + ": " + frequency);
		}
	}

}
