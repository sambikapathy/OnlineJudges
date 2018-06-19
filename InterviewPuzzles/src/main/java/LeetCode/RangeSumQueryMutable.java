package LeetCode;

public class RangeSumQueryMutable {

	static class TreeNode {
		int start;
		int end;
		int sum;
		TreeNode leftChild;
		TreeNode rightChild;

		public TreeNode(int left, int right, int sum) {
			this.start = left;
			this.end = right;
			this.sum = sum;
		}

		public TreeNode(int left, int right) {
			this.start = left;
			this.end = right;
			this.sum = 0;
		}
	}

	static public class NumArray {

		TreeNode root;

		public NumArray(int[] nums) {
			root = construct(nums, 0, nums.length - 1);
		}

		public TreeNode construct(int[] nums, int s, int e) {
			if (s > e) {
				return null;
			}
			if (s == e) {
				return new TreeNode(s, e, nums[s]);
			}
			int mid = s + (e - s) / 2;
			TreeNode temp = new TreeNode(s, e);
			temp.leftChild = construct(nums, s, mid);
			temp.rightChild = construct(nums, mid + 1, e);
			temp.sum = (temp.leftChild != null ? temp.leftChild.sum : 0)
					+ (temp.rightChild != null ? temp.rightChild.sum : 0);
			return temp;

		}

		void update(int i, int val) {

		}

		public int sumRange(int i, int j) {
			return -1;
		}

		public void inorder(TreeNode root) {
			if (root == null) {
				return;
			}
			inorder(root.leftChild);
			System.out.println(root.sum);
			inorder(root.rightChild);
		}
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5 };
		NumArray array = new NumArray(nums);
		System.out.println(array.root.sum);
		// array.inorder(array.root);
	}
}
