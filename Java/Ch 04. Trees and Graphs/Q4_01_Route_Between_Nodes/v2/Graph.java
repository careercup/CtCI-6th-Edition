package Q4_01_Route_Between_Nodes.v2;


import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }

    public void addNode(Node newNode) {
        vertices.add(newNode);
    }

    public List<Node> getNodes() {
        return vertices;
    }
}