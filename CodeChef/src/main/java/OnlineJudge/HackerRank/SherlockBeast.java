package OnlineJudge.HackerRank;

import java.util.Scanner;

public class SherlockBeast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int input = in.nextInt();
			int max = 0;
			int maxj = 0, maxk = 0;
			for (int j = 0; j <= input / 3; j++) {
				int k = (input - (j * 3)) / 5;
				int total = j * 3 + k * 5;
				if (total == input) {
					if (j + k > max) {
						max = j + k;
						maxj = j;
						maxk = k;
					}
				}
			}
			String result = (getString('5', maxj * 3) + getString('3', maxk * 5));
			if (result.length() == 0) {
				System.out.println("-1");
			} else {
				System.out.println(result);
			}
		}

	}

	private static String getString(char c, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(c);
		}
		return sb.toString();
	}
}
