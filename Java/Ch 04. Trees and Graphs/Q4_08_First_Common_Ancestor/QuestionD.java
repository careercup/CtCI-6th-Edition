package Q4_08_First_Common_Ancestor;

import CtCILibrary.TreeNode;

public class QuestionD {
	
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (!covers(root, p) || !covers(root, q)) { // Error check - one node is not in tree
			return null;
		}
		return ancestorHelper(root, p, q);
	}
	
	public static TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		
		boolean pIsOnLeft = covers(root.left, p);
		boolean qIsOnLeft = covers(root.left, q);
		if (pIsOnLeft != qIsOnLeft) { // Nodes are on different side
			return root;
		}
		TreeNode childSide = pIsOnLeft ? root.left : root.right;
		return ancestorHelper(childSide, p, q);
	}	
	
	public static boolean covers(TreeNode root, TreeNode p) { 
		if (root == null) return false;
		if (root == p) return true;
		return covers(root.left, p) || covers(root.right, p); 
	}
		
	
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(1);
		TreeNode n7 = root.find(7);
		TreeNode ancestor = commonAncestor(root, n3, n7);
		System.out.println(ancestor.data);
	}

}
