package Recursion;

//https://careercup.com/question?id=5679991586029568
public class PermuteNumbersWithSign {
	/**
	 * +1+2+3 = 6 +12+3 = 15 +123 = 123 +1+23 = 24 ... -1-2-3 = 6
	 */
	public static void perm(String input, String prefix, int index) {

		if (index >= input.length()) {
			System.out.println(prefix);
			return;
		}

		if (prefix.length() > 0) {
			perm(input, prefix + input.charAt(index), index + 1);
		}
		perm(input, prefix + "+" + input.charAt(index), index + 1);

	}

	public static void main(String[] args) {
		String input = "123";
		perm(input, "", 0);
	}
}
