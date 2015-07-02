package Q4_09_BST_Sequences;

import java.util.ArrayList;
import java.util.LinkedList;

import CtCILibrary.TreeNode;

public class Question {
	
	public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		/* One list is empty. Add the remainder to [a cloned] prefix and
		 * store result. */
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		
		/* Recurse with head of first added to the prefix. Removing the
		 * head will damage first, so we’ll need to put it back where we
		 * found it afterwards. */
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		/* Do the same thing with second, damaging and then restoring
		 * the list.*/
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();	
		second.addFirst(headSecond);
	}
	
	public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		
		if (node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		} 
		
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.data);
		
		/* Recurse on left and right subtrees. */
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		
		/* Weave together each list from the left and right sides. */
		for (LinkedList<Integer> left : leftSeq) {
			for (LinkedList<Integer> right : rightSeq) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(100);
		int[] array = {100, 50, 20, 75, 150, 120, 170};
		for (int a : array) {
			node.insertInOrder(a);
		}
		ArrayList<LinkedList<Integer>> allSeq = allSequences(node);
		for (LinkedList<Integer> list : allSeq) {
			System.out.println(list);
		}
		System.out.println(allSeq.size());
	}

}
