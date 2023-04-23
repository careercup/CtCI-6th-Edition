package Q15_04_Deadlock_Free_Class;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;

public class LockFactory {
	private static LockFactory instance;
	
	private int numberOfLocks = 5; /* default */
	private LockNode[] locks;
	
	/* Maps from a process or owner to the order that the owner claimed it would call the locks in */
	private HashMap<Integer, LinkedList<LockNode>> lockOrder;
	
	private LockFactory(int count) {
		numberOfLocks = count;
		locks = new LockNode[numberOfLocks];
		lockOrder = new HashMap<Integer, LinkedList<LockNode>>();
		for (int i = 0; i < numberOfLocks; i++) {
			locks[i] = new LockNode(i, count);
		}
	}
	
	public static LockFactory getInstance() {
		return instance;
	}
	
	public static LockFactory initialize(int count) {
		if (instance == null) {
			instance = new LockFactory(count);
		}
		return instance;
	}
	
	public boolean hasCycle(HashMap<Integer, Boolean> touchedNodes, int[] resourcesInOrder) {
		/* check for a cycle */
		for (int resource : resourcesInOrder) {
			if (touchedNodes.get(resource) == false) {
				LockNode n = locks[resource];
				if (n.hasCycle(touchedNodes)) {
					return true;
				}
			}
		}
		return false;
	}

	/* To prevent deadlocks, force the processes to declare upfront what order they will
	 * need the locks in. Verify that this order does not create a deadlock (a cycle in a directed graph)
	 */
	public boolean declare(int ownerId, int[] resourcesInOrder) {
		HashMap<Integer, Boolean> touchedNodes = new HashMap<Integer, Boolean>();
		
		/* add nodes to graph */
		int index = 1;
		touchedNodes.put(resourcesInOrder[0], false);
		for (index = 1; index < resourcesInOrder.length; index++) {
			LockNode prev = locks[resourcesInOrder[index - 1]];
			LockNode curr = locks[resourcesInOrder[index]];
			prev.joinTo(curr);
			touchedNodes.put(resourcesInOrder[index], false);
		}
		
		/* if we created a cycle, destroy this resource list and return false */
		if (hasCycle(touchedNodes, resourcesInOrder)) {
			for (int j = 1; j < resourcesInOrder.length; j++) {
				LockNode p = locks[resourcesInOrder[j - 1]];
				LockNode c = locks[resourcesInOrder[j]];
				p.remove(c);
			}
			return false;
		}
		
		/* No cycles detected. Save the order that was declared, so that we can verify that the
		 * process is really calling the locks in the order it said it would. */
		LinkedList<LockNode> list = new LinkedList<LockNode>();
		for (int i = 0; i < resourcesInOrder.length; i++) {
			LockNode resource = locks[resourcesInOrder[i]];
			list.add(resource);
		}
		lockOrder.put(ownerId, list);
		
		return true;
	}
	
	/* Get the lock, verifying first that the process is really calling the locks in the order
	 * it said it would. */
	public Lock getLock(int ownerId, int resourceID) {
		LinkedList<LockNode> list = lockOrder.get(ownerId);
		if (list == null) {
			return null;
		}
		
		LockNode head = list.getFirst();
		if (head.getId() == resourceID) {
			list.removeFirst();
			return head.getLock();
		}
		return null;
	}
}
