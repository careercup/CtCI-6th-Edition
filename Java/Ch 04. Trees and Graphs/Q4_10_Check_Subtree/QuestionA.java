package Q4_10_Check_Subtree;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class QuestionA {
	public static enum Order {
		PRE, IN, POST
	}
	
	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		return isTraversalSubstring(t1, t2, Order.PRE) && isTraversalSubstring(t1, t2, Order.IN);
	}
	
	public static boolean isTraversalSubstring(TreeNode t1, TreeNode t2, Order order) {
		StringBuilder string1 = new StringBuilder();
		StringBuilder string2 = new StringBuilder();
		
		getOrderString(t1, string1, order);
		getOrderString(t2, string2, order);
		
		return string1.indexOf(string2.toString()) != -1;
	}
	
	public static void getOrderString(TreeNode node, StringBuilder sb, Order order) {
		if (node == null) {
			sb.append("X"); // Add null indicator
			return;
		}
		if (order == Order.PRE) sb.append(node.data); // Add root if preorder
		getOrderString(node.left, sb, order); // Add left
		if (order == Order.IN) sb.append(node.data); // Add root if inorder
		getOrderString(node.right, sb, order); // Add right
		if (order == Order.POST) sb.append(node.data); // Add root if postorder 
	}

	public static void main(String[] args) {
		// t2 is a subtree of t1
		int[] array1 = {1, 2, 1, 3, 1, 1, 5};
		int[] array2 = {1, 1, 1};
		
		TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
		TreeNode t2 = AssortedMethods.createTreeFromArray(array2);

		if (containsTree(t1, t2)) {
			System.out.println("t2 is a subtree of t1");
		} else {
			System.out.println("t2 is not a subtree of t1");
		}

		// t4 is not a subtree of t3
		int[] array3 = {1, 2, 3};
		TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
		TreeNode t4 = AssortedMethods.createTreeFromArray(array3);

		if (containsTree(t3, t4)) {
			System.out.println("t4 is a subtree of t3");
		} else {
			System.out.println("t4 is not a subtree of t3");
		}
	}

}
