package Q9_02_Social_Network;

import java.util.LinkedList;

public class PathNode {
	private Person person = null;
	private PathNode previousNode = null;
	public PathNode(Person p, PathNode previous) {
		person = p;
		previousNode = previous;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public LinkedList<Person> collapse(boolean startsWithRoot) {
		LinkedList<Person> path = new LinkedList<Person>();
		PathNode node = this;
		while (node != null) {
			if (startsWithRoot) {
				path.addLast(node.person);
			} else {
				path.addFirst(node.person);
			}
			node = node.previousNode;
		}
		return path;
	}
}
