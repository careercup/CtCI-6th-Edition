package Q9_02_Social_Network;

import java.util.HashMap;
import java.util.LinkedList;

public class Tester {

	public static void printPeople(LinkedList<Person> path) {
		if (path == null) {
			System.out.println("No path");
		} else {
			for (Person p : path) {
				System.out.println(p.getID());
			}
		}		
	}
	
	public static boolean isEqual(LinkedList<Person> path1, LinkedList<Person> path2, boolean reverse) {
		if (path1 == null || path2 == null) {
			return path1 == null && path2 == null;
		}
		if (path1.size() != path2.size()) {
			return false;
		}
		
		for (int i = 0; i < path1.size(); i++) {
			int other = reverse ? path2.size() - i - 1 : i;
			if (path1.get(i) != path2.get(other)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isEquivalent(LinkedList<Person> path1, LinkedList<Person> path2) {
		boolean f1 = isEqual(path1, path2, false);
		boolean f2 = isEqual(path1, path2, true);
		return f1 || f2;
	}	
	
	public static void main(String[] args) {
		int nPeople = 11;
		HashMap<Integer, Person> people = new HashMap<Integer, Person>();
		for (int i = 0; i < nPeople; i++) {
			Person p = new Person(i);
			people.put(i, p);
		}
		
		int[][] edges = {{1, 4}, {1, 2}, {1, 3}, {3, 2}, {4, 6}, {3, 7}, {6, 9}, {9, 10}, {5, 10}, {2, 5}, {3, 7}};
		//int[][] edges = {{1, 4}, {1, 2}, {4, 6}, {6, 9}, {9, 10}, {5, 10}, {2, 5}};
		//int[][] edges = {{1, 2}, {1, 4}, {2, 3}, {3, 4}, {4, 6}, {5, 6}, {4, 5}}; 
		for (int[] edge : edges) {
			Person source = people.get(edge[0]);
			source.addFriend(edge[1]);
			
			Person destination = people.get(edge[1]);
			destination.addFriend(edge[0]);
		}
		
		/*int i = 1;
		int j = 10;
		LinkedList<Person> path1 = findPathBFS(people, i, j);
		LinkedList<Person> path2 = findPathBiBFS(people, i, j);
		System.out.println("Path 1");
		printPeople(path1);
		System.out.println("Path 2");
		printPeople(path2);*/
		
		
		for (int i = 0; i < nPeople; i++) {
			for (int j = 0; j < nPeople; j++) {
				LinkedList<Person> path1 = QuestionA.findPathBFS(people, i, j);
				LinkedList<Person> path2 = QuestionB.findPathBiBFS(people, i, j);
				if (!isEquivalent(path1, path2)) {
					System.out.println("Not equal: " + i + " to " + j);
					System.out.println("Path 1");
					printPeople(path1);
					System.out.println("Path 2");
					printPeople(path2);
					break;
				} else {
					System.out.println("Is equal: " + i + " to " + j);
				}
			}
		}
	}

}
