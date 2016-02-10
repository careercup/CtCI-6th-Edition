package Q4_03_List_of_Depths;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class QuestionDFS {

	public static void createLevelLinkedList(TreeNode root, List<LinkedList<TreeNode>> lists, int level) {
		if (root == null) return;
		LinkedList<TreeNode> list = null;
		if (lists.size() == level) { // Level not contained in list
			list = new LinkedList<TreeNode>();
			/* Levels are always traversed in order. So, if this is the first time we've visited level i,
			 * we must have seen levels 0 through i - 1. We can therefore safely add the level at the end. */
			lists.add(list);  
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}

	public static List<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		List<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}

	public static void printResult(List<LinkedList<TreeNode>> result) {
		int depth = 0;
		for (List<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	

	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		List<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
	}

}
