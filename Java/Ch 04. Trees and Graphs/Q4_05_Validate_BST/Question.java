package Q4_05_Validate_BST;

import CtCILibrary.TreeNode;

public class Question {
	public static Integer lastPrinted = null;

	public static boolean checkBST(TreeNode node) {
		return checkBST(node, true);
	}

	// Allow "equal" value only for left child. This validates the BST property.
	public static boolean checkBST(TreeNode n, boolean isLeft) {
		if (n == null) {
			return true;
		}
		
		// Check / recurse left
		if (!checkBST(n.left, true)) {
			return false;
		}
		
		// Check current
		if (lastPrinted != null) {
			if (isLeft) {
				// left child "is allowed" be equal to parent.
				if (n.data < lastPrinted) {
					return false;
				}
			} else {
				// Right child "is not allowed" be equal to parent.
				if (n.data <= lastPrinted) {
					return false;
				}
			}
		}
		lastPrinted = n.data;
		
		// Check / recurse right
		if (!checkBST(n.right, false)) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
		TreeNode node = TreeNode.createMinimalBST(array);
		//node.left.data = 5;
		//node.left.right.data = 3;
		System.out.println(checkBST(node));

		test();
	}

	public static void test() {
		TreeNode node;
		boolean condition;
		System.out.println("test cases for equals condition.");

		/* Expect true: for left child: node.data <= last_printed.
   2
  / \
 /   \
 2   3
      \
      4
		*/
		int[] array2 = {1, 2, 3, 4};
		node = TreeNode.createMinimalBST(array2);
		node.left.data = 2;
		node.print();
		lastPrinted = null;
		condition = checkBST(node);
		System.out.println("should be true: " + condition);

		/* Expect false: for right child: node.data <= last_printed.
   2
  / \
 /   \
 1   2
      \
      4
		 */
		int[] array3 = {1, 2, 3, 4};
		node = TreeNode.createMinimalBST(array3);
		node.right.data = 2;
		node.print();
		lastPrinted = null;
		condition = checkBST(node);
		System.out.println("should be false: " + condition);
	}
}