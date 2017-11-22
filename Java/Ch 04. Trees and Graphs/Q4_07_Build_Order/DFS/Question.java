package Q4_07_Build_Order.DFS;

import java.util.LinkedList;
import java.util.List;

import static Q4_07_Build_Order.DFS.Project.State.*;

public class Question {
	/* Build the graph, adding the edge (a, b) if b is dependent on a.
	 * Assumes a pair is listed in “build order” (which is the reverse
	 * of dependency order). The pair (a, b) in dependencies indicates
	 * that b depends on a and a must be built before a. */
	private static Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		for (String project : projects) {
			graph.getOrCreateNode(project);
		}

		for (String[] dependency : dependencies) {
			graph.addEdge(dependency[0], dependency[1]);
		}

		return graph;
	}

	private static void doDFS(Project project, LinkedList<Project> results) {
		if (project.getState() == PARTIAL) {
			throw new IllegalStateException("Circular Dependency.");
		} else if (project.getState() == BLANK) {
			project.setState(PARTIAL);
			for (Project child : project.getChildren()) {
				doDFS(child, results);
			}
			project.setState(COMPLETE);
			results.addFirst(project);
		}
	}

	private static Iterable<Project> orderProjects(List<Project> projects) {
		LinkedList<Project> stack = new LinkedList<>();
		for (Project project : projects) {
			doDFS(project, stack);
		}
		return stack;
	}

	public static void main(String[] args) {
		String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		String[][] dependencies = {
				{"a", "b"},
				{"b", "c"},
				{"a", "c"},
				{"d", "e"},
				{"b", "d"},
				{"e", "f"},
				{"a", "f"},
				{"h", "i"},
				{"h", "j"},
				{"i", "j"},
				{"g", "j"}};
		try {
			Graph graph = buildGraph(projects, dependencies);
			for (Project project : orderProjects(graph.getNodes())) {
				System.out.println(project.getName());
			}
		}
		catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}
}
