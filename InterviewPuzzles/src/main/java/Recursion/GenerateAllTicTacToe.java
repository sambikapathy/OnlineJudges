package Recursion;

import java.util.HashSet;
import java.util.Set;

public class GenerateAllTicTacToe {

	private static Set<String> set = new HashSet<>();

	public static void generateTTT(String input, String prefix, int x, int o, int index) {

		if (index >= 9 || (x == 0 || o == 0)) {
			if ((x == 0 || o == 0) && Math.abs(x - o) <= 1) {
				// System.out.println(prefix);
				if (isValid(prefix) && !set.contains(prefix)) {
					print(prefix);
					System.out.println();
					set.add(prefix);
				}
			}
			return;
		}
		generateTTT(input, prefix + "X", x - 1, o, index + 1);
		generateTTT(input, prefix + "O", x, o - 1, index + 1);
		generateTTT(input, prefix + ".", x, o, index + 1);

	}

	private static boolean isValid(String prefix) {
		for (int i = prefix.length(); i < 9; i++) {
			prefix = prefix + ".";
		}

		for (int i = 0; i < 3; i++) {
			if (prefix.charAt(i * 3 + 0) == prefix.charAt(i * 3 + 1)
					&& prefix.charAt(i * 3 + 0) == prefix.charAt(i * 3 + 2) && prefix.charAt(i * 3 + 0) != '.') {
				return true;
			}
		}

		if (prefix.charAt(0) == prefix.charAt(1) && prefix.charAt(0) == prefix.charAt(2) && prefix.charAt(0) != '.') {
			return true;
		}

		return false;
	}

	private static void print(String input) {
		int index = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				char c = '.';
				if (index < input.length()) {
					c = input.charAt(index++);
				}
				System.out.print(c + "|");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String input = "123";
		generateTTT(input, "", 3, 3, 0);
	}
}
