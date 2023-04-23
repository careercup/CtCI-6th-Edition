package CtCILibrary;

import java.util.LinkedList;
import java.util.Queue;

/* One node of a binary tree. The data element stored is a single 
 * character.
 */
public class TreeNode {
	public int data;      
	public TreeNode left;    
	public TreeNode right; 
	public TreeNode parent;
	private int size = 0;

	public TreeNode(int d) {
		data = d;
		size = 1;
	}
	
	private void setLeftChild(TreeNode left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}
	
	private void setRightChild(TreeNode right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}
	
	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null) {
				setLeftChild(new TreeNode(d));
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				setRightChild(new TreeNode(d));
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isBST() {
		if (left != null) {
			if (data < left.data || !left.isBST()) {
				return false;
			}
		}
		
		if (right != null) {
			if (data >= right.data || !right.isBST()) {
				return false;
			}
		}		
		
		return true;
	}
	
	public int height() {
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
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
	
	private static TreeNode createMinimalBST(int arr[], int start, int end){
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.setLeftChild(createMinimalBST(arr, start, mid - 1));
		n.setRightChild(createMinimalBST(arr, mid + 1, end));
		return n;
	}
	
	public static TreeNode createMinimalBST(int[] array) {
		return createMinimalBST(array, 0, array.length - 1);
	}
	
	public static TreeNode createMinimalBSTIterative(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}
	
	public static TreeNode createMinimalBSTIterative( int[] array, int start, int end){
		if (end < start) {
			return null;
		}
		
		int mid = (start + end)/2;
		// Root for return
		TreeNode root = new TreeNode(array[mid]);

		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		Queue<Integer> indexes = new LinkedList<Integer>();
		// Node, Indexes queuing for processing
		nodes.add(root);
		indexes.add(start);
		indexes.add(end);
		
		while (nodes.peek()!=null) {

			TreeNode node = nodes.poll();
		
			start = indexes.poll();
			end = indexes.poll();
			mid = (start + end ) /2;
		
			// does it have left child?		
			if(mid>start){
				// find and Assign left if available
				int left = (start + mid -1 )/2;
				TreeNode leftNode = new TreeNode (array[left]);
				node.setLeftChild (leftNode);
		
				// Node, Indexes queuing for processing
				nodes.add(leftNode);
				// Left side , Start is constant
				indexes.add (start);
				// Left side, end is variable
				indexes.add (mid-1);
			}
			//does it have right child?
			if (mid<end) {
				// find and Assign right if available
				int right = (mid+1 + end) / 2;
				TreeNode rightNode = new TreeNode (array[right]);
				node.setRightChild (rightNode);
		
				// Node, Indexes queuing for processing
				nodes.add(rightNode);
				// right side, start is variable
				indexes.add(mid+1);
				// right side, end is constant
				indexes.add (end);
			}

		}

		return root;

	}
	
	public void print() {
		BTreePrinter.printNode(this);
	}
} 
