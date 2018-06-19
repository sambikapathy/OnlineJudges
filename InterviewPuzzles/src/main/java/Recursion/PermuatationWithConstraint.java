package Recursion;

public class PermuatationWithConstraint {

	static int count = 0, count2 = 0;

	private static void perm(String prefix, String input) {
		if (input.length() == 0) {
			System.out.println(prefix);
			count++;
			return;
		}

		for (int i = 0; i < input.length(); i++) {
			perm(prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1));
		}
	}

	private static void maxDiffOnePerm(String prefix, String input) {
		if (input.length() == 0) {
			System.out.println(prefix);
			count2++;
			return;
		}

		for (int i = 0; i < input.length(); i++) {

			char f = prefix.length() > 0 ? prefix.charAt(prefix.length() - 1) : input.charAt(i);
			char l = input.charAt(i);

			if (Math.abs(f - l) <= 1) {
				maxDiffOnePerm(prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1));
			}
		}
	}

	public static void main(String[] args) {

		String input = "1111";
		// perm("", input);
		maxDiffOnePerm("", input);
		System.out.println(count + " " + count2);
	}
}
