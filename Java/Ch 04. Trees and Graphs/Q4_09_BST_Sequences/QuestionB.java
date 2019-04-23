package Q4_09_BST_Sequences;

import CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class QuestionB {
	public static List<List<Integer>> allSequences(TreeNode root) {
		return allSequences(root, new LinkedHashSet<>(), root.size(), new ArrayList<>());
	}
	private static List<List<Integer>> allSequences(TreeNode node, Set<TreeNode> nodes, int size, List<List<Integer>> results) {
		nodes.add(node);

		if (nodes.size() == size) {
			List<Integer> result = new ArrayList<>();
			for (TreeNode n : nodes) {
				result.add(n.data);
			}
			results.add(result);
		} else {
			for (TreeNode n : nodes) {
				for (TreeNode child : asList(n.left, n.right)) {
					if (child != null && !nodes.contains(child)) {
						allSequences(child, new LinkedHashSet<>(nodes), size, results);
					}
				}
			}
		}

		return results;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(100);
		int[] array = {50, 20, 75, 150, 120, 170};
		for (int a : array) {
			node.insertInOrder(a);
		}
		List<List<Integer>> allSeq = allSequences(node);
		for (List<Integer> list : allSeq) {
			System.out.println(list);
		}
		System.out.println(allSeq.size());
	}
}
