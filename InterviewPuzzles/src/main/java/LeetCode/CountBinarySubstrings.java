package LeetCode;

public class CountBinarySubstrings {
	/*
	 * Input: "00110011" Output: 6 Explanation: There are 6 substrings that have
	 * equal number of consecutive 1's and 0's: "0011", "01", "1100", "10",
	 * "0011", and "01".
	 * 
	 * Notice that some of these substrings repeat and are counted the number of
	 * times they occur.
	 * 
	 * Also, "00110011" is not a valid substring because all the 0's (and 1's)
	 * are not grouped together.
	 */

	public static void main(String[] args) {
		String input = "111000";
		System.out.println(countBinaryStringsRec(input));
	}

	private static int countBinaryStringsRec(String input) {
		int[] count = new int[input.length()];
		count[0] = 1;
		char[] charArray = input.toCharArray();
		for (int i = 1; i < charArray.length; i++) {
			if (charArray[i] == charArray[i - 1]) {
				count[i] = count[i - 1] + 1;
			} else {
				count[i] = 1;
			}
		}
		int total = 0;
		for (int i = 1; i < charArray.length; i++) {
			if (charArray[i] == charArray[i - 1]) {
				continue;
			} else {
				int start = i;
				while (start + 1 < charArray.length && charArray[start] == charArray[start + 1]) {
					start++;
				}
				int min = Math.min(count[start], count[i - 1]);
				total += min;
				i += min - 1;
			}
		}
		return total;
	}
}
