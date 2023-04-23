package Q17_12_BiNode;

public class QuestionA {
	private static class NodePair {
		BiNode head;
		BiNode tail;

		public NodePair(BiNode head, BiNode tail)  {
			this.head = head;
			this.tail = tail;
		}
	}
	
	public static NodePair convert(BiNode root) {
		if (root == null) {
			return null;
		}
		
		NodePair part1 = convert(root.node1);
		NodePair part2 = convert(root.node2);
		
		if (part1 != null) {
			concat(part1.tail, root);
		}
		
		if (part2 != null) {
			concat(root, part2.head);
		}
		
		return new NodePair(part1 == null ? root : part1.head, part2 == null ? root : part2.tail);
	}	
	
	public static void concat(BiNode x, BiNode y) {
		x.node2 = y;
		y.node1 = x;
	}

	public static void printLinkedListTree(BiNode root) {
		for (BiNode node = root; node != null; node = node.node2) {
			if (node.node2 != null && node.node2.node1 != node) {
				System.out.print("inconsistent node: " + node);
			}
			System.out.print(node.data + "->");
		}
		System.out.println();
	}

	public static BiNode createTree() {
		BiNode[] nodes = new BiNode[7];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new BiNode(i);
		}
		nodes[4].node1 = nodes[2];
		nodes[4].node2 = nodes[5];
		nodes[2].node1 = nodes[1];
		nodes[2].node2 = nodes[3];
		nodes[5].node2 = nodes[6];
		nodes[1].node1 = nodes[0];
		return nodes[4];
	}

	public static void printAsTree(BiNode root, String spaces) {
		if (root == null) {
			System.out.println(spaces + "- null");
			return;
		}
		System.out.println(spaces + "- " + root.data);
		printAsTree(root.node1, spaces + "   ");
		printAsTree(root.node2, spaces + "   ");
	}

	public static void main(String[] args) {
		BiNode root = createTree();
		printAsTree(root, "");
		NodePair n = convert(root);
		printLinkedListTree(n.head);
	}

}
