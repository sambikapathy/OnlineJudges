package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {

	private static List<Integer> list = new ArrayList<Integer>();

	public static int coinChange(int n, int index, int[] input) {
		if (n == 0) {
			for (int j : list) {
				System.out.print(j + " ");
			}
			System.out.println();
			return 1;
		}
		int total = 0;
		for (int i = index; i < input.length; i++) {
			if (input[i] <= n) {
				list.add(input[i]);
				total += coinChange(n - input[i], i, input);
				list.remove(list.size() - 1);
			}
		}
		return total;
	}

	public static void main(String[] args) {
		int n = 6;
		int[] input = { 1, 2, 3 };
		// int n = 10;
		// int []input = {2,5,3,6};
		System.out.println(coinChange(n, 0, input));

	}
}
