package Introduction;

import java.util.*;

public class IntroductionCollections {
	public static void main(String[] args) {
		// ArrayList
		List<String> myArr = new ArrayList<>();
		myArr.add("one");
		myArr.add("two");
		System.out.println(myArr.get(0));
		
		// Vector
		List<String> myVect = new Vector<>();
		myVect.add("one");
		myVect.add("two");
		System.out.println(myVect.get(0));
		
		// Linked List
		Deque<String> myLinkedList = new LinkedList<>();
		myLinkedList.add("two");
		myLinkedList.addFirst("one");
		for (String value : myLinkedList) {
			System.out.println(value);
		}
		
		// Hash Map
		Map<String, String> map = new HashMap<>();
		map.put("one", "uno");
		map.put("two", "dos");
		System.out.println(map.get("one"));
	}
}
