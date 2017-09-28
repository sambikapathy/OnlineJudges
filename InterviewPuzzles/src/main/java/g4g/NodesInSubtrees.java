package g4g;

import tree.BinaryTree;
import tree.Node;

/*
 *    1
 *   4 2
 *  3 5
 *  
 *  1 -> 5
 *  2 -> 1
 *  3 -> 1
 *  4 -> 3
 *  5 -> 1
 */
public class NodesInSubtrees {

	private static int calculateNodeInSubtrees(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		System.out.println(root.data);
		root.data = calculateNodeInSubtrees(root.left) + calculateNodeInSubtrees(root.right) + 1;
		return root.data;
	}

	public static void main(String[] args) {
		// int[] input = { 1, 4, 2, 3, 5 };
		int[] input = { 0, 0, 0, 0, 0 };
		BinaryTree root3 = new BinaryTree(input);
		calculateNodeInSubtrees(root3.getRoot());
		root3.levelOrder(root3.getRoot());
	}
}
