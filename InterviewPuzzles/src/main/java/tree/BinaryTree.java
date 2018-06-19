package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
	Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public BinaryTree(int[] array) {
		root = createTree(array);
	}

	public void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public void printPreorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		printInorder(node.left);
		printInorder(node.right);
	}

	public void printPostorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		printInorder(node.right);
		System.out.println(node.data);
	}

	private Node createTree(int[] array) {
		Node root = new Node(array[0]);
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root);
		int index = 1;
		while (!q.isEmpty()) {
			Node temp = q.poll();
			Node left = getNode(index++, array);
			Node right = getNode(index++, array);

			temp.left = left;
			temp.right = right;

			if (left != null) {
				q.add(left);
			}
			if (right != null) {
				q.add(right);
			}
		}
		return root;
	}

	private static Node getNode(int index, int[] array) {
		if (index >= array.length) {
			return null;
		}
		return new Node(array[index]);
	}

	// FIXME look for traversing a threaded binary tree
	public void threadedTree(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		if (node.left != null && node.left.right == null) {
			node.left.right = node;
		}
		// System.out.print(node.data+" ");
		printInorder(node.right);
	}

	public int size(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}

	public boolean isIdentical(Node tree1, Node tree2) {

		if (tree1 == null && tree2 == null) {
			return true;
		}
		if (tree1 != null && tree2 != null) {
			if (tree1.data != tree2.data) {
				return false;
			}
			return isIdentical(tree1.left, tree2.left) && isIdentical(tree1.right, tree2.right);
		}
		return false;
	}

	public int height(Node tree) {
		if (tree == null) {
			return 0;
		}
		return 1 + max(height(tree.left), height(tree.right));
	}

	private int max(int height, int height2) {
		if (height > height2) {
			return height;
		}
		return height2;
	}

	public void mirrorImage(Node root) {
		if (root == null) {
			return;
		}

		mirrorImage(root.left);
		mirrorImage(root.right);
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	private List<Node> stack = new ArrayList<Node>();

	public void printAllPaths(Node root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			for (Node node : stack) {
				System.out.print(node.data + " ");
			}
			System.out.println(root.data);
			System.out.println();
			return;
		}
		stack.add(root);
		printAllPaths(root.left);
		printAllPaths(root.right);
		stack.remove(root);
	}

	public void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			Node element = q.poll();
			System.out.println(element.data);
			if (element.left != null) {
				q.offer(element.left);
			}
			if (element.right != null) {
				q.offer(element.right);
			}
		}
	}

	public void childrenProperty(Node<Integer> root) {

		if (root == null) {
			return;
		}

		childrenProperty(root.left);
		childrenProperty(root.right);
		int ld = getData(root.left);
		int rd = getData(root.right);

		int total = ld + rd;
		if (total == root.data) {
			return;
		} else if (total > root.data) {
			root.data = total;
		} else {
			int diff = root.data - total;
			if (root.left != null) {
				root.left.data = root.left.data + diff;
				childrenProperty(root.left);
			} else {
				if (root.right != null) {
					root.right.data = root.right.data + diff;
					childrenProperty(root.right);
				}
			}
		}
	}

	private int getData(Node<Integer> node) {
		if (node == null) {
			return 0;
		}
		return node.data;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5 };
		int[] input2 = { 1, 2, 3, 2, 5 };
		int[] input3 = { 50, 7, 2, 3, 5, 1, 30 };

		// BinaryTree root = new BinaryTree(input);

		// BinaryTree root2 = new BinaryTree(input2);
		// root.printInorder(root.root);
		// System.out.println();
		// root.printPreorder(root.root);
		// System.out.println();
		// root.printPostorder(root.root);

		// root.threadedTree(root.root);

		// System.out.println(root.size(root.root));
		// System.out.println(root.isIdentical(root.root , root2.root));
		// System.out.println(root.height(root.root));

		// root.printInorder(root.root);
		// System.out.println();
		// root.mirrorImage(root.root);
		// root.printInorder(root.root);
		// System.out.println();

		// root.printAllPaths(root.root);
		BinaryTree root3 = new BinaryTree(input3);
		root3.printInorder(root3.root);
		System.out.println();
		root3.childrenProperty(root3.root);
		root3.printInorder(root3.root);
		System.out.println();
	}
}
