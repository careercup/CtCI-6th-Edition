package Q4_05_Validate_BST;

import CtCILibrary.TreeNode;

public class Question {
    private static int prevNodeValue = 0;
    private static int closestRightParent = 0;

    public static boolean CompareCurrToPrev(int currVal)
    {
        if (currVal >= prevNodeValue && currVal > closestRightParent)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isBST(TreeNode node)
    {
        if (node != null)
        {
            // Recurse Left
            boolean leftBST = isBST(node.left);
            if (!leftBST)
            {
                return false;
            }

            // Visit node
            boolean doBST = CompareCurrToPrev(node.data);
            if (!doBST)
            {
                return false;
            }
            prevNodeValue = node.data;

            // Recurse right
            closestRightParent = node.data;
            boolean rightBST = isBST(node.right);
            if (!rightBST)
            {
                return false;
            }
            closestRightParent = 0;
        }

        return true;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(16);

        System.out.println(isBST(root));
    }
}
