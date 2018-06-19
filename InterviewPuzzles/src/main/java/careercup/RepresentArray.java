package careercup;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RepresentArray {

	/**
	 *
	 * 
	 * How to print nested array ? Input : [1, 5, 8, [9, 10, 24, 20, [39, 48],
	 * 89], 105, 99] Output : 1, 5, 8, 9, 10, 24, 20, 39, 48, 89, 105, 99.
	 * 
	 * Which data structure you will use to store the values?
	 */

	public static void main(String[] args) {

		String input = "[1, 5, 8, [9, 10, 24, 20, [39, 48],89], 105, 99]".replaceAll(" ", "");
		ArrayNode node = new RepresentArray().construct(input);
		System.out.println(node.print());
	}

	private ArrayNode construct(String inputS) {

		char[] input = inputS.toCharArray();
		Stack<ArrayNode> stack = new Stack<>();
		ArrayNode result = null;
		for (int i = 0; i < input.length; i++) {
			char c = input[i];
			if (c == '[') {
				ArrayNode arrayNode = new RepresentArray.ArrayNode();
				if (!stack.isEmpty()) {
					stack.peek().add(arrayNode);
				}
				stack.push(arrayNode);
			} else if (c == ']') {
				result = stack.pop();
			} else if (c == ',') {

			} else {
				StringBuilder sb = new StringBuilder();
				while (input[i] >= '0' && input[i] <= '9') {
					sb.append(input[i++]);
				}
				stack.peek().add(new ArrayNode(sb.toString()));
				i--;
			}
		}
		return result;
	}

	class ArrayNode {
		String value;
		List<ArrayNode> elements = new ArrayList<>();

		public ArrayNode() {

		}

		public String print() {
			if (!elements.isEmpty()) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				for (ArrayNode node : elements) {
					sb.append(node.print());
				}
				sb.append("]");
				return sb.toString();
			} else {
				return value + ",";
			}
		}

		public void add(ArrayNode node) {
			elements.add(node);
		}

		public ArrayNode(String data) {
			this.value = data;
		}

		public ArrayNode(String data, List<ArrayNode> list) {
			this.value = data;
			this.elements = list;
		}
	}
}
