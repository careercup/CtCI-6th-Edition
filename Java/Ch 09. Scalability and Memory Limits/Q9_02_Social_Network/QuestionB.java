package Q9_02_Social_Network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class QuestionB {

	public static LinkedList<Person> mergePaths(BFSData bfs1, BFSData bfs2, int connection) {
		PathNode end1 = bfs1.visited.get(connection); // end1 -> source
		PathNode end2 = bfs2.visited.get(connection); // end2 -> dest
		LinkedList<Person> pathOne = end1.collapse(false); // forward: source -> connection
		LinkedList<Person> pathTwo = end2.collapse(true); // reverse: connection -> dest
		pathTwo.removeFirst(); // remove connection
		pathOne.addAll(pathTwo); // add second path
		return pathOne;
	}
	
	/* Search one level and return collision, if any. */
	public static Person searchLevel(HashMap<Integer, Person> people, BFSData primary, BFSData secondary) {
		/* We only want to search one level at a time. Count how many nodes are currently in the primary's
		 * level and only do that many nodes. We'll continue to add nodes to the end. */
		int count = primary.toVisit.size(); 
		for (int i = 0; i < count; i++) {
			/* Pull out first node. */
			PathNode pathNode = primary.toVisit.poll();
			int personId = pathNode.getPerson().getID();
			
			/* Check if it's already been visited. */
			if (secondary.visited.containsKey(personId)) {
				return pathNode.getPerson();
			}				
			
			/* Add friends to queue. */
			Person person = pathNode.getPerson();
			ArrayList<Integer> friends = person.getFriends();
			for (int friendId : friends) {
				if (!primary.visited.containsKey(friendId)) {
					Person friend = people.get(friendId);
					PathNode next = new PathNode(friend, pathNode);
					primary.visited.put(friendId, next);
					primary.toVisit.add(next);
				}
			}
		}
		return null;
	}
	
	public static LinkedList<Person> findPathBiBFS(HashMap<Integer, Person> people, int source, int destination) {
		BFSData sourceData = new BFSData(people.get(source));
		BFSData destData = new BFSData(people.get(destination));
		
		while (!sourceData.isFinished() && !destData.isFinished()) {
			/* Search out from source. */
			Person collision = searchLevel(people, sourceData, destData);
			if (collision != null) {
				return mergePaths(sourceData, destData, collision.getID());
			}
			
			/* Search out from destination. */
			collision = searchLevel(people, destData, sourceData);
			if (collision != null) {
				return mergePaths(sourceData, destData, collision.getID());
			}
		}
		return null;
	}	
	
	public static void main(String[] args) {
		int nPeople = 11;
		HashMap<Integer, Person> people = new HashMap<Integer, Person>();
		for (int i = 0; i < nPeople; i++) {
			Person p = new Person(i);
			people.put(i, p);
		}
		
		int[][] edges = {{1, 4}, {1, 2}, {1, 3}, {3, 2}, {4, 6}, {3, 7}, {6, 9}, {9, 10}, {5, 10}, {2, 5}, {3, 7}};
		
		for (int[] edge : edges) {
			Person source = people.get(edge[0]);
			source.addFriend(edge[1]);
			
			Person destination = people.get(edge[1]);
			destination.addFriend(edge[0]);
		}
		
		int i = 1;
		int j = 10;
		LinkedList<Person> path1 = findPathBiBFS(people, i, j);
		Tester.printPeople(path1);
	}

}
