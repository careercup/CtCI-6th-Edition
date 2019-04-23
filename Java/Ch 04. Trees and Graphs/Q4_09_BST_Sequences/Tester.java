package Q4_09_BST_Sequences;

import CtCILibrary.TreeNode;

import java.util.HashSet;

public class Tester {
	public static void main(String[] args) {
		TreeNode node = new TreeNode(100);
		int[] array = {50, 20, 75, 150, 120, 170};
		for (int a : array) {
			node.insertInOrder(a);
		}

		HashSet allSeqA = new HashSet<>(QuestionA.allSequences(node));
		HashSet allSeqB = new HashSet<>(QuestionB.allSequences(node));

		if (allSeqA.equals(allSeqB)) {
			System.out.println("Success!");
		} else {
			System.err.println("Error: QuestionA differs from QuestionB!");
			System.err.println("QuestionA:" + allSeqA);
			System.err.println("QuestionB:" + allSeqB);
		}
	}
}
