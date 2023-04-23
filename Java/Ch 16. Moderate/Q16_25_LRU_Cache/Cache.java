package Q16_25_LRU_Cache;

import java.util.HashMap;

public class Cache {			
	private int maxCacheSize;
	private HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();
	private LinkedListNode listHead = null;
	public LinkedListNode listTail = null;
	
	
	public Cache(int maxSize) {
		maxCacheSize = maxSize;
	}
	
	/* Get value for key and mark as most recently used. */
	public String getValue(int key) {
		LinkedListNode item = map.get(key);
		if (item == null) {
			return null;
		}
		
		/* Move to front of list to mark as most recently used. */
		if (item != listHead) { 
			removeFromLinkedList(item);
			insertAtFrontOfLinkedList(item);
		}
		return item.value;
	}
	
	/* Remove node from linked list. */
	private void removeFromLinkedList(LinkedListNode node) {
		if (node == null) {
			return;
		}
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		if (node == listTail) {
			listTail = node.prev;
		}
		if (node == listHead) {
			listHead = node.next;
		}		
	}
	
	/* Insert node at front of linked list. */
	private void insertAtFrontOfLinkedList(LinkedListNode node) {
		if (listHead == null) {
			listHead = node;
			listTail = node;
		} else {
			listHead.prev = node;
			node.next = listHead;
			listHead = node;
			listHead.prev = null;
		}
	}
	
	/* Remove key, value pair from cache, deleting from hash table
	 * and linked list. */
	public boolean removeKey(int key) {
		LinkedListNode node = map.get(key);
		removeFromLinkedList(node);
		map.remove(key);
		return true;
	}
	
	/* Put key, value pair in cache. Removes old value for key if
	 * necessary. Inserts pair into linked list and hash table.*/
	public void setKeyValue(int key, String value) {
		/* Remove if already there. */
		removeKey(key); 
		
		/* If full, remove least recently used item from cache. */
		if (map.size() >= maxCacheSize && listTail != null) {
			removeKey(listTail.key);
		}
		
		/* Insert new node. */
		LinkedListNode node = new LinkedListNode(key, value);
		insertAtFrontOfLinkedList(node);
		map.put(key, node);
	}
	
	public String getCacheAsString() {
		if (listHead == null) return "";
		return listHead.printForward();
	}
	
	private class LinkedListNode {
		private LinkedListNode next;
		private LinkedListNode prev;
		public int key;
		public String value;
		public LinkedListNode(int k, String v) {
			key = k;
			value = v;
		}
		
		public String printForward() {
			String data = "(" + key + "," + value + ")";
			if (next != null) {
				return data + "->" + next.printForward();
			} else {
				return data;
			}
		}
	}	
}
