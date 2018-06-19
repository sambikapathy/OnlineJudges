package HackerRank.Strings;

public class BuildAString {

	private static int minimumCost(int target, int a, int b, String result) {
		String start = "";
		int i = 0;
		int cost = 0;
		int[] costs = new int[result.length()];
		costs[0] = a;
		while (i < result.length()) {
			if (i == 0) {
				start += result.charAt(0);
				i++;
			} else {
				int temp = Integer.MAX_VALUE;
				int index = -1;
				String match1 = "";
				for (int j = 1; i - j >= 0; j++) {
					String match = result.substring(i - j, i + 1);
					for (int k = 0; k <= start.length() - match.length(); k++) {
						boolean found = true;
						for (int x = 0; x < match.length(); x++) {
							if (match.charAt(x) != start.charAt(k + x)) {
								found = false;
								break;
							}
						}
						if (found) {
							if (costs[i - match.length()] + b < temp) {
								temp = costs[i - match.length()] + b;
								index = match.length();
								match1 = match;
							}
						}
					}
				}
				costs[i] = Math.min(temp, costs[i - 1] + a);
				start += result.charAt(i);
				i++;
			}
			System.out.println(start);
		}
		return costs[costs.length - 1];
	}

	public static void main(String[] args) {
		int[][] numbers = { { 9, 4, 5 }, { 9, 8, 9 } };
		String[] input = { "aabaacaba", "bacbacacb" };

		int n = 2;
		for (int i = 0; i < n; i++) {
			int target = numbers[i][0];
			int a = numbers[i][1];
			int b = numbers[i][2];
			String str = input[i];
			System.out.println(minimumCost(target, a, b, str));
		}
	}
}
