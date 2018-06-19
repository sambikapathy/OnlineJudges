package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static TreeNode createTree(int[] input) {
		if (input == null || input.length == 0) {
			return null;
		}
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode head = new TreeNode(input[0]);
		q.add(head);
		int index = 1;
		while (!q.isEmpty()) {
			TreeNode poll = q.poll();

			if (index < input.length) {
				int val = input[index++];
				TreeNode left = null;
				if (val > 0) {
					left = new TreeNode(val);
				}
				poll.left = left;
				if (poll.left != null) {
					q.add(poll.left);
				}
			}

			if (index < input.length) {
				int val = input[index++];
				TreeNode right = null;
				if (val > 0) {
					right = new TreeNode(val);
				}
				poll.right = right;
				if (poll.right != null) {
					q.add(poll.right);
				}
			}
		}
		return head;
	}

	public static void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.val);
			inorder(node.right);
		}
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6 };
		TreeNode head = createTree(input);
		inorder(head);
	}

}