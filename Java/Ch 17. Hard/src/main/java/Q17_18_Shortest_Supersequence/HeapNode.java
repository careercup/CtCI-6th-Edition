package Q17_18_Shortest_Supersequence;

public class HeapNode implements Comparable<HeapNode> {
	public int locationWithinList;
	public int listId;
	
	public HeapNode(int location, int list) {
		locationWithinList = location;
		listId = list;
	}

	@Override
	public int compareTo(HeapNode n) {
		return locationWithinList - n.locationWithinList;
	}	
}
