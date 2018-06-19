package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class IterativeInorderWithParentPointerTree {
	/*
	 * Iterative In order traversal where each node has a parent pointer. nO
	 * extra space
	 * 
	 * Do the same for postorder and preorder as well
	 * 
	 * Find inorder successor
	 */

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		Node root = Node.createTree(input, 0);
		root.inorder(root);
		System.out.println();
		root.inorderTailRecursive(root);
		System.out.println();
		root.iterativeInorderWithSpace(root);
		// System.out.println(root.left.getParent().getData());
		// root.iterativeInorder(root);
	}

	static class Node {
		@Override
		public String toString() {
			return "Node [data=" + data + ", " + (left != null ? "left=" + left + ", " : "")
					+ (right != null ? "right=" + right + ", " : "") + (parent != null ? "parent=" + parent : "") + "]";
		}

		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		public static Node createTree(List<Integer> input, int index) {
			if (index >= input.size()) {
				return null;
			}
			Node curr = new Node(input.get(index));
			curr.left = createTree(input, index * 2 + 1);
			curr.right = createTree(input, index * 2 + 2);
			if (curr.left != null) {
				curr.left.parent = curr;
			}
			if (curr.right != null) {
				curr.right.parent = curr;
			}
			return curr;
		}

		/**
		 * 1 2 3 4 5
		 * 
		 * @param root
		 */

		public void iterativeInorder(Node root) {

			Set<Node> set = new HashSet<>();
			Stack<Node> stack = new Stack<>();
			stack.add(root);

			while (root != null) {

				if (!set.contains(root.left)) {
					stack.push(root.left);
					set.add(root.left);
					continue;
				}
				System.out.print(stack.pop().data + ",");
				if (!set.contains(root.right)) {
					stack.push(root.right);
					set.add(root.right);
				}
			}
		}

		public void iterativeInorderWithSpace(Node root) {
			Set<Node> set = new HashSet<>();
			Stack<Node> stack = new Stack<>();
			stack.add(root);

			while (!stack.isEmpty()) {
				root = stack.peek();
				if (root == null) {
					stack.pop();
					continue;
				}
				if (!set.contains(root.left)) {
					stack.push(root.left);
					set.add(root.left);
					continue;
				}
				System.out.print(stack.pop().data + ",");
				if (!set.contains(root.right)) {
					stack.push(root.right);
					set.add(root.right);
				}
			}
		}

		public void inorder(Node root) {
			if (root == null) {
				return;
			}
			inorder(root.left);
			System.out.print(root.data + ",");
			inorder(root.right);
		}

		public void inorderTailRecursive(Node root) {
			if (root == null) {
				return;
			}
			while (root != null) {
				inorder(root.left);
				System.out.print(root.data + ",");
				root = root.right;
			}
			// inorder(root.right);
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		Node parent;
	}

}
