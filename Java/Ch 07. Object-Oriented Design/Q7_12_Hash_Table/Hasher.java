package Q7_12_Hash_Table;

import java.util.ArrayList;

public class Hasher<K, V> {
	private static class LinkedListNode<K, V> {
		public LinkedListNode<K, V> next;
		public LinkedListNode<K, V> prev;
		public K key;
		public V value;
		public LinkedListNode(K k, V v) {
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
	
	private ArrayList<LinkedListNode<K, V>> arr;
	public Hasher(int capacity) {
		/* Create list of linked lists. */
		arr = new ArrayList<LinkedListNode<K, V>>();
		arr.ensureCapacity(capacity);
		for (int i = 0; i < capacity; i++) {
			arr.add(null);
		}
	}
	
	/* Insert key and value into hash table. */
	public void put(K key, V value) {
		LinkedListNode<K, V> node = getNodeForKey(key);
		if (node != null) {
			node.value = value; // just update the value.
			return;
		}
		
		node = new LinkedListNode<K, V>(key, value);
		int index = getIndexForKey(key);
		if (arr.get(index) != null) {
			node.next = arr.get(index);
			node.next.prev = node;
		}
		arr.set(index, node);
	}
	
	/* Remove node for key. */
	public void remove(K key) {
		LinkedListNode<K, V> node = getNodeForKey(key);
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			/* Removing head - update. */
			int hashKey = getIndexForKey(key);
			arr.set(hashKey, node.next);
		}
		
		if (node.next != null) {
			node.next.prev = node.prev;
		}
	}
	
	/* Get value for key. */
	public V get(K key) {
		LinkedListNode<K, V> node = getNodeForKey(key);
		return node == null ? null : node.value;
	}
	
	/* Get linked list node associated with a given key. */
	private LinkedListNode<K, V> getNodeForKey(K key) {
		int index = getIndexForKey(key);
		LinkedListNode<K, V> current = arr.get(index);
		while (current != null) {
			if (current.key == key) {
				return current;
			}
			current = current.next;
		}
		return null;		
	}
	
	/* Really stupid function to map a key to an index. */
	public int getIndexForKey(K key) {
		return Math.abs(key.hashCode() % arr.size());
	}
	
	public void printTable() {
		for (int i = 0; i < arr.size(); i++) {
			String s = arr.get(i) == null ? "" : arr.get(i).printForward();
			System.out.println(i + ": " + s);
		}
	}
}