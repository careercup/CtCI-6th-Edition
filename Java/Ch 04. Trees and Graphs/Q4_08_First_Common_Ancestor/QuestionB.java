package Q4_08_First_Common_Ancestor;

import CtCILibrary.TreeNode;

public class QuestionB {
	public static TreeNode commonAncestor(TreeNode p, TreeNode q) {
		int depthDiff = depth(p) - depth(q);
		TreeNode shallowNode = depthDiff > 0 ? q : p;
		TreeNode deepNode = depthDiff > 0 ? p : q;

		deepNode = goUpBy(deepNode, Math.abs(depthDiff)); // move shallower node to depth of deeper
		while (shallowNode != deepNode) {
			shallowNode = shallowNode.parent;
			deepNode = deepNode.parent;
		}
		return shallowNode;
	}

	private static TreeNode goUpBy(TreeNode node, int delta) {
		while (delta > 0 && node != null) {
			node = node.parent;
			delta--;
		}
		return node;
	}
	
	public static int depth(TreeNode node) {
		int depth = 0;
		while (node != null) {
			node = node.parent;
			depth++;
		}
		return depth;
	}	
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(3);
		TreeNode n7 = root.find(7);
		TreeNode ancestor = commonAncestor(n3, n7);
		System.out.println(ancestor.data);
	}

}
