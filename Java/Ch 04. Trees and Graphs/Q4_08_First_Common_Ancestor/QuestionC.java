package Q4_08_First_Common_Ancestor;

import CtCILibrary.TreeNode;

public class QuestionC {

	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (covers(p, q)) {
			return p;
		} else if (covers(q, p)) {
			return q;
		} else if (!covers(root, p) || !covers(root, q)) {
			return null;
		}
		
		TreeNode sibling = getSibling(p);
		TreeNode parent = p.parent;
		while (!covers(sibling, q)) {
			sibling = getSibling(parent);
			parent = parent.parent;
		}
		return parent;
	}

	private static boolean covers(TreeNode root, TreeNode p) {
		return root != null
			   && (root == p
				   || covers(root.left, p)
				   || covers(root.right, p));
	}

	private static TreeNode getSibling(TreeNode node) {
		if (node == null || node.parent == null) {
			return null;
		}
		
		TreeNode parent = node.parent;
		return parent.left == node ? parent.right : parent.left;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n1 = root.find(1);
		TreeNode n7 = root.find(7);
		TreeNode ancestor = commonAncestor(root, n1, n7);
		System.out.println(ancestor.data);
	}

}
