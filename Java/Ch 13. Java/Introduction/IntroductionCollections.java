package Introduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class IntroductionCollections {
	public static void main(String[] args) {
		// ArrayList
		ArrayList<String> myArr = new ArrayList<String>();
		myArr.add("one");
		myArr.add("two");
		System.out.println(myArr.get(0));
		
		// Vector
		Vector<String> myVect = new Vector<String>();
		myVect.add("one");
		myVect.add("two");
		System.out.println(myVect.get(0));
		
		// Linked List
		LinkedList<String> myLinkedList = new LinkedList<String>();
		myLinkedList.add("two");
		myLinkedList.addFirst("one");
		Iterator<String> iter = myLinkedList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// Hash Map
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("one", "uno");
		map.put("two", "dos");
		System.out.println(map.get("one"));
	}
}
