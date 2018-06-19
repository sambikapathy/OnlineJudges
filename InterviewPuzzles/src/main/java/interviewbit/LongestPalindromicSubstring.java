package interviewbit;

/**
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer.
 * 
 *
 */
public class LongestPalindromicSubstring {

	public String longestPalindrome(String a) {

		int max = 1;
		String result = a.charAt(0) + "";
		for (int i = 1; i < a.length(); i++) {

			// odd
			int l = i - 1, r = i + 1;
			int count = 0;
			boolean fail = false;
			while (l >= 0 && r < a.length()) {
				if (a.charAt(l) != a.charAt(r)) {
					break;
				}
				count++;
				l--;
				r++;
				if (max < (count * 2 + 1)) {
					max = count * 2 + 1;
					result = a.substring(l + 1, r);
				}

			}
			// even
			l = i - 1;
			r = i;
			count = 0;
			fail = false;
			while (l >= 0 && r < a.length()) {
				if (a.charAt(l) != a.charAt(r)) {
					break;
				}
				count++;
				l--;
				r++;
				if (max < count * 2) {
					max = count * 2;
					result = a.substring(l + 1, r);
				}
			}

		}
		return result;
	}

	public static void main(String[] args) {

		String input = "abbcccbbbcaaccbababcbcabca";
		System.out.println(new LongestPalindromicSubstring().longestPalindrome(input));
	}
}
