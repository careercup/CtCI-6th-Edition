package Q4_04_Check_Balanced;

import CtCILibrary.TreeNode;

public class QuestionImproved {
	private static class UnbalancedTree extends Exception {}
	private static int checkHeight(TreeNode root) throws UnbalancedTree {
		if (root == null) return 0;

		int leftHeight = checkHeight(root.left);
		int rightHeight = checkHeight(root.right);

		if (Math.abs(leftHeight - rightHeight) <= 1) {
			return 1 + Math.max(leftHeight, rightHeight);
		} else {
			throw new UnbalancedTree();
		}
	}

	public static boolean isBalanced(TreeNode root) {
		try {
			checkHeight(root);
			return true;
		}
		catch (UnbalancedTree e) {
			return false;
		}
	}

	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);

		System.out.println("Is balanced? " + isBalanced(root));

		root.insertInOrder(4); /* Add 4 to make it unbalanced*/
		System.out.println("Is balanced? " + isBalanced(root));
	}
}
