package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import tree.BinaryTree;
import tree.Node;

public class LeavesOfTree {

	public static int getLeavesOfTree(Node<Integer> node, Map<Integer, List<Integer>> result) {
		if (node == null) {
			return 0;
		}

		int ll = getLeavesOfTree(node.left, result);
		int rl = getLeavesOfTree(node.right, result);

		int data = Math.max(ll, rl) + 1;
		if (!result.containsKey(data)) {
			result.put(data, new ArrayList<>());
		}
		result.get(data).add(node.data);
		return data;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 10 };
		BinaryTree tree = new BinaryTree(input);
		tree.printInorder(tree.getRoot());

		Map<Integer, List<Integer>> result = new TreeMap<>();
		getLeavesOfTree(tree.getRoot(), result);
		result.entrySet().stream().forEach(entry -> {
			// for(){
			//
			// }
		});

		System.out.println(Objects.toString(result));
	}
}
