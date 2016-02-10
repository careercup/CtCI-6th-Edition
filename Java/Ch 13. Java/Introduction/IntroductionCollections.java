package Introduction;

import java.util.*;

public class IntroductionCollections {
	public static void main(String[] args) {
		// ArrayList
		List<String> myArr = new ArrayList<String>();
		myArr.add("one");
		myArr.add("two");
		System.out.println(myArr.get(0));
		
		// Vector
		List<String> myVect = new Vector<String>();
		myVect.add("one");
		myVect.add("two");
		System.out.println(myVect.get(0));
		
		// Linked List
		Deque<String> myLinkedList = new LinkedList<String>();
		myLinkedList.add("two");
		myLinkedList.addFirst("one");
		Iterator<String> iter = myLinkedList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// Hash Map
		Map<String, String> map = new HashMap<String, String>();
		map.put("one", "uno");
		map.put("two", "dos");
		System.out.println(map.get("one"));
	}
}
