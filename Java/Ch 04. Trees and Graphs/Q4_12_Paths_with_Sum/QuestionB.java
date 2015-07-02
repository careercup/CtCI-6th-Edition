package Q4_12_Paths_with_Sum;
import java.util.HashMap;
import java.util.LinkedList;

import CtCILibrary.TreeNode;

public class QuestionB {
	
	public static int countPathsWithSum(TreeNode root, int targetSum) {
		if (root == null) return 0;
		HashMap<Integer, Integer> pathCount = new HashMap<Integer, Integer>();
		incrementHashTable(pathCount, 0, 1); // Needed if a "target sum" path starts from root 
		return countPathsWithSum(root, targetSum, 0, pathCount);
	}
	
	public static int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
		if (node == null) return 0; // Base case
		
		runningSum += node.data;
		incrementHashTable(pathCount, runningSum, 1); // Add runningSum
		
		/* Count paths with sum ending at the current node. */
		int sum = runningSum - targetSum;
		int totalPaths = pathCount.containsKey(sum) ? pathCount.get(sum) : 0;
		
		/* Count paths with sum on the left and right. */
		totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
		totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
		
		incrementHashTable(pathCount, runningSum, -1); // Remove runningSum
		return totalPaths;
	}
	
	public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
		if (!hashTable.containsKey(key)) {
			hashTable.put(key, 0);
		}
		hashTable.put(key, hashTable.get(key) + delta);
	}

	public static void main(String [] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);		
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);	
		root.right.left.left = new TreeNode(0);	
		//TreeNode r = new TreeNode(10);
		//r.left = root;
		System.out.println(countPathsWithSum(root, 8));
	}
}

