package Q4_12_Paths_with_Sum;

import CtCILibrary.TreeNode;

public class QuestionA {
	
	public static int countPathsWithSum(TreeNode root, int targetSum) {
		if (root == null) return 0;
		
		/* Count paths with sum starting from the root. */
		int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
		
		/* Try the nodes on the left and right. */
		int pathsOnLeft = countPathsWithSum(root.left, targetSum);
		int pathsOnRight = countPathsWithSum(root.right, targetSum);
		
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}
	
	/* Returns the number of paths with this sum starting from this node. */
	public static int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
		if (node == null) return 0;
	
		currentSum += node.data;
		
		int totalPaths = 0;
		if (currentSum == targetSum) { // Found a path from the root
			totalPaths++;
		}
		
		totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum); // Go left
		totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum); // Go right
		
		return totalPaths;
	}	

	public static void main(String [] args) {
		/*
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);		
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);	
		System.out.println(countPathsWithSum(root, 0));*/
		
		/*TreeNode root = new TreeNode(-7);
		root.left = new TreeNode(-7);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(20);
		root.right.right.left = new TreeNode(0);
		root.right.right.left.left = new TreeNode(-3);
		root.right.right.left.left.right = new TreeNode(2);
		root.right.right.left.left.right.left = new TreeNode(1);
		System.out.println(countPathsWithSum(root, -14));*/
		
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(0);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.left.right = new TreeNode(0);
		root.right.right = new TreeNode(0);
		System.out.println(countPathsWithSum(root, 0));
		System.out.println(countPathsWithSum(root, 4));
	}
}

