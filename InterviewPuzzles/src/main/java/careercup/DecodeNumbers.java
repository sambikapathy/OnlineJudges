package careercup;

public class DecodeNumbers {

	/**
	 * 12 -> 12 & 1,2 -> 2 1322241043 -> 10 132241043 -> 6
	 * 
	 */
	private static int decode(String input, String prefix, int count) {

		if (input.length() == 0) {
			System.out.println(prefix);
			return 1;
		}

		char c = input.charAt(0);
		int total = 0;
		if (c != '0' && prefix.length() > 0) {
			total = decode(input.substring(1), prefix + "," + c, count);
		}
		return total + decode(input.substring(1), prefix + c, count);
	}

	public static void main(String[] args) {
		String input = "132241043";
		System.out.println(decode(input, "", 0));
	}

}
