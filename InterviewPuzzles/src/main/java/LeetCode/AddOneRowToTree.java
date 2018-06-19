package LeetCode;

/*
 * Input: 
A binary tree as following:
       4
     /   \
    2     6
   / \   / 
  3   1 5   

v = 1

d = 2

Output: 
       4
      / \
     1   1
    /     \
   2       6
  / \     / 
 3   1   5   
 * 
 
 A binary tree as following:
      4
     /   
    2    
   / \   
  3   1    

v = 1

d = 3

Output: 
      4
     /   
    2
   / \    
  1   1
 /     \  
3       1
 */
public class AddOneRowToTree {

	public void inorder(TreeNode node, int depth, int v, int d) {
		if (node == null) {
			return;
		}

		if (depth + 1 == d) {
			TreeNode left = new TreeNode(v);
			TreeNode right = new TreeNode(v);
			left.left = node.left;
			right.right = node.right;
			node.left = left;
			node.right = right;
			return;
		}

		inorder(node.left, depth + 1, v, d);
		inorder(node.right, depth + 1, v, d);
	}

	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode node = new TreeNode(v);
			node.left = root;
			return node;
		}
		inorder(root, 1, v, d);
		return root;
	}

	public static void main(String[] args) {
		int[] input = { 4, 2, 6, 3, 1, 5 };
		TreeNode root = TreeNode.createTree(input);
		TreeNode.inorder(root);
		System.out.println();
		new AddOneRowToTree().addOneRow(root, 1, 1);
		TreeNode.inorder(root);
	}

}
