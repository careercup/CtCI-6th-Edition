package Q4_05_Validate_BST;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class QuestionB {
	private static boolean checkBST(TreeNode n, Integer min, Integer max) {
		if (n == null) {
			return true;
		} else if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		} else {
			return checkBST(n.left, min, n.data) &&
				   checkBST(n.right, n.data, max);
		}
	}

	public static boolean checkBST(TreeNode n) {
		return checkBST(n, null, null);
	}
	
	public static boolean checkBSTAlternate(TreeNode n) {
		return checkBSTAlternate(n, new AtomicInteger(0), new AtomicInteger(0));
	}

	private static boolean checkBSTAlternate(TreeNode n, AtomicInteger min, AtomicInteger max) {
		/* An alternate, less clean approach. This is not provided in the book, but is used to test the other method. */
		if (n.left == null) {
			min.set(n.data);
		} else {
			AtomicInteger leftMin = new AtomicInteger(0);
			AtomicInteger leftMax = new AtomicInteger(0);
			if (!checkBSTAlternate(n.left, leftMin, leftMax)) {
				return false;
			}
			if (leftMax.get() > n.data) {
				return false;
			}
			min.set(leftMin.get());
		}
		if (n.right == null) {
			max.set(n.data);
		} else {
			AtomicInteger rightMin = new AtomicInteger(0);
			AtomicInteger rightMax = new AtomicInteger(0);
			if (!checkBSTAlternate(n.right, rightMin, rightMax)) {
				return false;
			}
			if (rightMin.get() <= n.data) {
				return false;
			}
			max.set(rightMax.get());
		}
		return true;
	}

	/* Create a tree that may or may not be a BST */
	public static TreeNode createTestTree() {
		/* Create a random BST */
		TreeNode head = AssortedMethods.randomBST(10, -10, 10); 
		
		/* Insert an element into the BST and potentially ruin the BST property */
		TreeNode node = head;
		do {
			int n = AssortedMethods.randomIntInRange(-10, 10);
			int rand = AssortedMethods.randomIntInRange(0, 5);
			if (rand == 0) {
				node.data = n;
			} else if (rand == 1) {
				node = node.left;
			} else if (rand == 2) {
				node = node.right;
			} else if (rand == 3 || rand == 4) {
				break;
			}
		} while (node != null);	
		
		return head;
	}
	
	public static void main(String[] args) {
		/* Simple test -- create one */
		int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};
		TreeNode node = TreeNode.createMinimalBST(array);
		//node.left.data = 6; // "ruin" the BST property by changing one of the elements
		node.print();
		boolean isBst = checkBST(node);
		System.out.println(isBst);
		
		/* More elaborate test -- creates 100 trees (some BST, some not) and compares the outputs of various methods. */
		/*for (int i = 0; i < 100; i++) {
			TreeNode head = createTestTree();
			
			// Compare results 
			boolean isBst1 = checkBST(head);
			boolean isBst2 = checkBSTAlternate(head);
			
			if (isBst1 != isBst2) {
				System.out.println("*********************** ERROR *******************");
				head.print();
				break;
			} else {
				System.out.println(isBst1 + " | " + isBst2);
				head.print();
			}
		}*/
	}
}
