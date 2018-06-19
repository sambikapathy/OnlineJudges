package DynamicProgramming;

public class LongestCommonSubsequence {

	private static int lcs(String a, String b) {

		int[][] dp = new int[a.length() + 1][b.length() + 1];
		for (int i = 0; i < a.length() + 1; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < b.length() + 1; i++) {
			dp[0][i] = 0;
		}

		for (int i = 1; i < a.length() + 1; i++) {
			for (int j = 1; j < b.length() + 1; j++) {

				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		for (int i = 0; i < a.length() + 1; i++) {
			for (int j = 0; j < b.length() + 1; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = a.length(); i > 0;) {
			for (int j = b.length(); j > 0 && i > 0;) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					System.out.print(a.charAt(i - 1));
					i--;
					j--;
				} else {
					if (dp[i - 1][j] > dp[i][j - 1]) {
						i--;
						break;
					} else {
						j--;
					}

				}
			}
		}
		return dp[a.length()][b.length()];
	}

	public static void main(String[] args) {
		String a = "abcdabd";
		String b = "abdabd";
		System.out.println(lcs(a, b));

	}
}
