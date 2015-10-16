package Q4_08_First_Common_Ancestor;

import java.util.ArrayList;

import CtCILibrary.TreeNode;

public class Tester {
	public static String resultToString(String s, TreeNode x, TreeNode y, TreeNode anc) {
		s += ": ";
		s += (x == null ? "null" : x.data);
		s += " & ";
		s += (y == null ? "null" : y.data);
		s += " -> ";
		s += (anc == null ? "null" : anc.data);
		return s;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		for (int a : array) {
			nodes.add(root.find(a));
		}
		nodes.add(new TreeNode(11));
		
		for (TreeNode x : nodes) {
			for (TreeNode y : nodes) {
				TreeNode r1 = QuestionA.commonAncestor(x, y);
				TreeNode r2 = QuestionB.commonAncestor(x, y);
				TreeNode r3 = QuestionC.commonAncestor(root, x, y);
				TreeNode r4 = QuestionD.commonAncestor(root, x, y);
				TreeNode r5 = QuestionE.commonAncestor(root, x, y);
				
				String s1 = resultToString("A", x, y, r1);
				String s2 = resultToString("B", x, y, r2);
				String s3 = resultToString("C", x, y, r3);
				String s4 = resultToString("D", x, y, r4);
				String s5 = resultToString("D", x, y, r5);
				
				if (r1 == r2 && r2 == r3 && r3 == r4 && r4 == r5) {
					System.out.println("SUCCESS: " + s1);
				} else {
					System.out.println("ERROR");
					System.out.println(s1);
					System.out.println(s2);
					System.out.println(s3);
					System.out.println(s4);
					System.out.println(s5);
				}
			}
		}
	}

}
