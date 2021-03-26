package Q4_07_Build_Order.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Question {
    /* Build the graph, adding the edge (a, b) if b is dependent on a.
     * Assumes a pair is listed in “build order”. The pair (a, b) in
     * dependencies indicates that b depends on a and a must be built
     * before b. */
    public static Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }

    public static List<Project> orderProjects(List<Project> projects) {

        LinkedList<Project> queue = new LinkedList<>();
        for (Project project : projects) {
            if (project.getParents().size() == 0) {
                queue.add(project);
            }
        }

        List<Project> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            Project r = queue.removeFirst();
            if(!r.isProcessed() && r.getParents().stream().allMatch(Project::isProcessed)) {
                r.setProcessed(true);
                result.add(r);
                for (Project project : r.getChildren()) {
                    if(!project.isProcessed()) {
                        queue.add(project);
                    }
                }
            }


        }
        return result;
    }

    public static List<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    public static List<String> buildOrderWrapper(String[] projects, String[][] dependencies) {
        List<Project> buildOrder = findBuildOrder(projects, dependencies);
        if (buildOrder == null) return null;
        List<String> buildOrderString = buildOrder.stream().map(Project::getName).collect(Collectors.toList());
        return buildOrderString;
    }

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"}};
        List<String> buildOrder = buildOrderWrapper(projects, dependencies);
        if (buildOrder.isEmpty()) {
            System.out.println("Circular Dependency.");
        } else {
            for (String s : buildOrder) {
                System.out.println(s);
            }
        }
    }

}
