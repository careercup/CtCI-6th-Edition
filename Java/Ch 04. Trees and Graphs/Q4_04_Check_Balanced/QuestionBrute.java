package Q4_04_Check_Balanced;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class QuestionBrute {
	private static int getHeight(TreeNode root) {
		return (root != null) ? 1 + Math.max(getHeight(root.left), getHeight(root.right))
							  : 0;
	}

	public static boolean isBalanced(TreeNode root) {
		return root == null
			   || (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1
				   && isBalanced(root.left) && isBalanced(root.right));
	}

	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Is balanced? " + isBalanced(root));

		// Could be balanced, actually, but it's very unlikely...
		TreeNode unbalanced = new TreeNode(10);
		for (int i = 0; i < 10; i++) {
			unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
		}
		System.out.println("Root? " + unbalanced.data);
		System.out.println("Is balanced? " + isBalanced(unbalanced));
	}
}
