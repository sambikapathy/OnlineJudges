package careercup;

import java.util.Stack;

public class ReverseString {

	/*
	 * Reverse this string 1+2*3-20. Note: 20 must be retained as is. Expected
	 * output: 20-3*2+1
	 */

	private static String reverse(String input) {
		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c >= '0' && c <= '9') {
				sb.append(c);
			} else {
				stack.push(sb.toString());
				stack.push(c + "");
				sb = new StringBuilder();
			}
		}
		if (sb.length() > 0) {
			stack.push(sb.toString());
		}
		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String input = "1+2*3-20";
		System.out.println(reverse(input));
	}
}
