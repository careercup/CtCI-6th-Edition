package Q4_06_Successor;

import CtCILibrary.TreeNode;

public class Question {

	public static TreeNode inorderSucc(TreeNode n) { 
		if (n == null) return null;
		
		// Found right children -> return left most node of right subtree
		if (n.parent == null || n.right != null) { 
			return leftMostChild(n.right); 
		} else { 
			TreeNode q = n;
			TreeNode x = q.parent;
			// Go up until we're on left instead of right
			while (x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}  
	} 
		
	public static TreeNode leftMostChild(TreeNode n) {
		if (n == null) {
			return null;
		}
		while (n.left != null) {
			n = n.left; 
		}
		return n; 
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = inorderSucc(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}

}
