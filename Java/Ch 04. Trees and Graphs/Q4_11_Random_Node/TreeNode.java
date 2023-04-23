package Q4_11_Random_Node;

import java.util.Random;

/* One node of a binary tree. The data element stored is a single 
 * character.
 */
public class TreeNode {
	public int data;      
	public TreeNode left;    
	public TreeNode right; 
	private int size = 0;

	public TreeNode(int d) {
		data = d;
		size = 1;
	}
	
	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null) {
				left = new TreeNode(d);
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				right = new TreeNode(d);
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public TreeNode find(int d) {
		if (d == data) {
			return this;
		} else if (d <= data) {
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}
	
	public TreeNode getRandomNode() {
		int leftSize = left == null ? 0 : left.size();
		Random random = new Random();
		int index = random.nextInt(size);
		if (index < leftSize) {
			return left.getRandomNode();
		} else if (index == leftSize) {
			return this;
		} else {
			return right.getRandomNode();
		}
	}
	
	public TreeNode getIthNode(int i) {
		int leftSize = left == null ? 0 : left.size();
		if (i < leftSize) {
			return left.getIthNode(i);
		} else if (i == leftSize) {
			return this;
		} else {
			return right.getIthNode(i - (leftSize + 1));
		}
	}
} 
