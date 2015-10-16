package Q4_08_First_Common_Ancestor;

import CtCILibrary.TreeNode;

public class QuestionEBad {
	public static TreeNode commonAncestorBad(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p && root == q) {
			return root;
		}
		
		TreeNode x = commonAncestorBad(root.left, p, q);
		if (x != null && x != p && x != q) { // Found common ancestor
			return x;
		}
		
		TreeNode y = commonAncestorBad(root.right, p, q);
		if (y != null && y != p && y != q) {
			return y;
		}
		
		if (x != null && y != null) {
			return root; // This is the common ancestor
		} else if (root == p || root == q) {
			return root;
		} else {
			return x == null ? y : x;
		}
	}	
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(9);
		TreeNode n7 = new TreeNode(6);//root.find(10);
		TreeNode ancestor = commonAncestorBad(root, n3, n7);
		if (ancestor != null) {
			System.out.println(ancestor.data);
		} else {
			System.out.println("null");
		}
	}

}
