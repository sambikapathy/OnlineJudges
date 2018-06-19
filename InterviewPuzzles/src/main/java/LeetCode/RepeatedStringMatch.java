package LeetCode;

//https://leetcode.com/contest/leetcode-weekly-contest-52/problems/repeated-string-match/
public class RepeatedStringMatch {
	/*
	 * For example, with A = "abcd" and B = "cdabcdab".
	 * 
	 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
	 * substring of it; and B is not a substring of A repeated two times
	 * ("abcdabcd").
	 * 
	 * acbc -> cacbcac
	 * 
	 */

	public int repeatedMatch(String input, String match) {

		for (int i = 0; i < input.length(); i++) {
			int index = i;
			boolean isDone = true;
			for (int j = 0; j < match.length(); j++) {
				if (match.charAt(j) != input.charAt(index % input.length())) {
					isDone = false;
					break;
				}
				index++;
			}
			if (isDone) {
				return (int) Math.ceil(index * 1.0f / input.length());
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String input = "abcd";
		String match = "cdabcdab";
		System.out.println(new RepeatedStringMatch().repeatedMatch(input, match));
		;
	}
	// a -> b -> c -> d
}
