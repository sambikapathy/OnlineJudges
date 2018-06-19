package problems;

public class Permutations {

	public static void printPerm(String prefix, String input) {
		if (input.length() == 0) {
			System.out.println(prefix);
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			printPerm(prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1));
		}
	}

	public static void printPermBacktrack(String input, int l, int r) {
		if (l == r) {
			System.out.println(input);
		}

		for (int i = l; i < r; i++) {
			input = swap(input, l, i);
			printPermBacktrack(input, l + 1, r);
			input = swap(input, l, i);
		}
	}

	private static String swap(String input, int l, int i) {
		StringBuilder sb = new StringBuilder(input);
		char c = input.charAt(l);
		sb.setCharAt(l, sb.charAt(i));
		sb.setCharAt(i, c);
		return sb.toString();
	}

	public static void main(String[] args) {

		String input = "abc";
		printPerm("", input);
		System.out.println("####");
		printPermBacktrack(input, 0, input.length());

	}
}
