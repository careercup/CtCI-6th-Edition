package Q15_04_Deadlock_Free_Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockNode {
	public enum VisitState {
		FRESH, VISITING, VISITED
	};
	
	private ArrayList<LockNode> children;
	private int lockId;
	private Lock lock;
	private int maxLocks;
	
	public LockNode(int id, int max) {
		lockId = id;
		children = new ArrayList<LockNode>();
		maxLocks = max;
	}
	
	/* Join "this" to "node", checking to make sure that it doesn't create a cycle */
	public void joinTo(LockNode node) {
		children.add(node);
	}
	
	public void remove(LockNode node) {
		children.remove(node);
	}
	
	/* Check for a cycle by doing a depth-first-search. */	
	public boolean hasCycle(HashMap<Integer, Boolean> touchedNodes) {
		VisitState[] visited = new VisitState[maxLocks];
		for (int i = 0; i < maxLocks; i++) {
			visited[i] = VisitState.FRESH;
		}
		return hasCycle(visited, touchedNodes);
	}
	
	private boolean hasCycle(VisitState[] visited, HashMap<Integer, Boolean> touchedNodes) {
		if (touchedNodes.containsKey(lockId)) {
			touchedNodes.put(lockId, true); 
		}
		
		if (visited[lockId] == VisitState.VISITING) {
			return true;
		} else if (visited[lockId] == VisitState.FRESH) {
			visited[lockId] = VisitState.VISITING;
			for (LockNode n : children) {
				if (n.hasCycle(visited, touchedNodes)) {
					return true;
				}
			}
			visited[lockId] = VisitState.VISITED;
		}
		return false;
	}
	
	public Lock getLock() {
		if (lock == null) {
			lock = new ReentrantLock();
		}
		return lock;
	}
	
	public int getId() {
		return lockId;
	}
}
