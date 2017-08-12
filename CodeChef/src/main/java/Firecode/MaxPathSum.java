package Firecode;

public class MaxPathSum {

	private static int max = 0;

	private static int maxSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int lm = maxSumPath(root.left);
		int rm = maxSumPath(root.right);
		if ((lm + rm + root.data) > max) {
			max = lm + rm + root.data;
		}
		return lm > rm ? lm + root.data : rm + root.data;
	}

	public static int maxSumPath(TreeNode root) {
		Integer i = new Integer(0);
		maxSum(root);
		return max;
	}

	public static void main(String[] args) {

		int[] input = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode[] nodes = new TreeNode[input.length];
		for (int i = 0; i < input.length; i++) {
			nodes[i] = new TreeNode(input[i], null, null);
		}

		for (int i = 1; i <= input.length; i++) {
			if (2 * i - 1 < input.length) {
				nodes[i - 1].left = nodes[2 * i - 1];
			}

			if ((2 * i) < input.length) {
				nodes[i - 1].right = nodes[2 * i];
			}
		}

		System.out.println(maxSumPath(nodes[0]));
		System.out.println(max);
	}
}

class TreeNode {
	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(int data, TreeNode left, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}