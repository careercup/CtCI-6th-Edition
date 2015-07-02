package Q4_01_Route_Between_Nodes;

public class Graph {
	private Node vertices[];
	public int count;
	public Graph() {
		vertices = new Node[6];
		count = 0;
    }
	
    public void addNode(Node x) {
		if (count < 30) {
			vertices[count] = x;
			count++;
		} else {
			System.out.print("Graph full");
		}
    }
    
    public Node[] getNodes() {
        return vertices;
    }
}

