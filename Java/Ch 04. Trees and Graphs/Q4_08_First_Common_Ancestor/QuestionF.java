package Q4_08_First_Common_Ancestor;

import CtCILibrary.TreeNode;

public class QuestionF {
	
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if ((p == null) || (q == null)) {
			return null;
		}
		
		TreeNode ap = p.parent;
		while (ap != null) {
			TreeNode aq = q.parent;
			while (aq != null) { 
				if (aq == ap) {
					return aq;
				}
				aq = aq.parent;
			}
			ap = ap.parent;
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[] array = {5, 3, 6, 1, 9, 11};
		TreeNode root = new TreeNode(20);
		for (int a : array) {
			root.insertInOrder(a);
		}
		TreeNode n1 = root.find(1);
		TreeNode n9 = root.find(9);
		TreeNode ancestor = commonAncestor(root, n1, n9);
		System.out.println(ancestor.data);
	}

}
