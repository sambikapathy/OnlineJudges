package DynamicProgramming;

import java.util.Arrays;

//ND
public class CoinChange_DP {

	private static void coinChange(int[] values, int target) {
		int[] cost = new int[target + 1];
		cost[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < values.length; j++) {
				if (i - values[j] >= 0) {
					cost[i] += cost[i - values[j]];
				}
			}
		}
		Arrays.stream(cost).forEach(id -> System.out.print(id + ","));
	}

	public static void main(String[] args) {
		int[] value = { 1, 2, 3 };
		int target = 6;
		coinChange(value, target);
	}
}
