package Backtracking;

import java.util.HashSet;
import java.util.Set;

public class RemoveInvalidParentheses {

	private int min = Integer.MAX_VALUE;

	public boolean removeInvalidParantheses(String input, int count, Set<String> result) {

		if (count > min) {
			return false;
		}

		if (isValid(input)) {
			if (count < min) {
				result.clear();
				result.add(input);
				min = count;
			} else if (count == min) {
				result.add(input);
			}
		}
		for (int i = 0; i < input.length(); i++) {
			removeInvalidParantheses(input.substring(0, i) + input.substring(i + 1), count + 1, result);
		}
		return false;
	}

	private boolean isValid(String input) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '(') {
				count++;
			} else if (c == ')') {
				count--;
			}
			if (count < 0) {
				return false;
			}
		}
		return count == 0;
	}

	public static void main(String[] args) {
		String input = "()())()";
		Set<String> result = new HashSet<>();
		new RemoveInvalidParentheses().removeInvalidParantheses(input, 0, result);
		System.out.println(result);
	}
}
