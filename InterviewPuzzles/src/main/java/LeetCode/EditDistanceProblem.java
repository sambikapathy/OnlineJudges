package LeetCode;

public class EditDistanceProblem {

	static int total = 0;

	public static int minDistanceDP(String word1, String word2) {
		int l1 = word1.length();
		int l2 = word2.length();
		int[][] dp = new int[l1 + 1][l2 + 1];

		// Init
		for (int i = 0; i < l1; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i < l2; i++) {
			dp[0][i] = i;
		}

		for (int i = 0; i < l1; i++) {
			char f = word1.charAt(i);
			for (int j = 0; j < l2; j++) {
				char s = word2.charAt(i);

				if (f == s) {
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					dp[i + 1][j + 1] = Math.min(dp[i][j] + 1, Math.min(dp[i + 1][j] + 1, dp[i][j + 1] + 1));

				}
			}
		}
		return dp[l1][l2];
	}

	public static int minDistanceRec(String word1, String word2, int count) {
		if (word1.length() == 0 || word2.length() == 0) {
			if (word1.length() == 0 && word2.length() == 0) {

				return count;
			}
			return Integer.MAX_VALUE;
		}
		total++;
		// int min = Math.min(word1.length(), word2.length());
		// replace insert delete
		int min = Integer.MAX_VALUE;
		if (word1.charAt(0) == word2.charAt(0)) {
			min = Math.min(minDistanceRec(word1.substring(1), word2.substring(1), count), min);
		} else {
			int t = minDistanceRec(word1, word2.substring(1), count + 1);
			t = Math.min(minDistanceRec(word1.substring(1), word2, count + 1), t);
			t = Math.min(minDistanceRec(word1.substring(1), word2.substring(1), count + 1), t);
			min = Math.min(t, min);
		}
		return min;
	}

	public static void main(String[] args) {

		String a = "abcabcabcabc";
		String b = "wecwecabcabc";
		System.out.println(minDistanceRec(a, b, 0));
		System.out.println(minDistanceDP(a, b));
		System.out.println(total);
	}
}

// TRIM
// seated
