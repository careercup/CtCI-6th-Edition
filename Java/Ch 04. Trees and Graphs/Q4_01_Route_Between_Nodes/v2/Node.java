package Q4_01_Route_Between_Nodes.v2;


import java.util.ArrayList;
import java.util.List;

class Node {
    private List<Node> adjacentNodes;
    private String vertex;
    public Question.State state;

    public Node(String vertex) {
        this.vertex = vertex;
        adjacentNodes = new ArrayList<>();
    }

    public void addAdjacent(Node node) {
        this.adjacentNodes.add(node);
    }

    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public String getVertex() {
        return vertex;
    }

    public int getAdjacentCount() {
        return adjacentNodes.size();
    }
}
