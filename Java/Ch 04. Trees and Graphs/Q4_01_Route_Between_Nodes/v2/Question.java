package Q4_01_Route_Between_Nodes.v2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question {
    public enum State {
        Unvisited, Visited;
    }

    public static void main(String a[]) {
        Graph g = createNewGraph();
        List<Node> nodes = g.getNodes();
        Node start = nodes.get(4);
        Node end = nodes.get(5);
        System.out.println(search(g, start, end));
    }

    public static Graph createNewGraph() {
        Graph g = new Graph();
        List<Node> temp = new ArrayList<>();

        temp.add(new Node("a"));
        temp.add(new Node("b"));
        temp.add(new Node("c"));
        temp.add(new Node("d"));
        temp.add(new Node("e"));
        temp.add(new Node("f"));

        temp.get(0).addAdjacent(temp.get(1));
        temp.get(0).addAdjacent(temp.get(2));
        temp.get(0).addAdjacent(temp.get(3));
        temp.get(3).addAdjacent(temp.get(4));
        temp.get(4).addAdjacent(temp.get(5));

        for (int i = 0; i < temp.size(); i++) {
            g.addNode(temp.get(i));
        }
        return g;
    }

    public static boolean search(Graph g, Node start, Node end) {
        LinkedList<Node> q = new LinkedList<>();
        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Node v : u.getAdjacentNodes()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        }
                        q.add(v);
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }
}
