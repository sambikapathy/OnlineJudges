package LeetCode;

import java.util.List;
import java.util.Stack;

public class NQueens_2 {
	private static int[][] placeQueen(int n, int[][] input, Stack<Pair> stack, int x, int j) {
		if (n == 0 || j >= input.length) {
			return input;
		}
		for (int i = x; i < input.length; i++) {
			// for (int j = y; j < n; j++) {
			if (canPlace(input, i, j)) {
				input[i][j] = 1;
				stack.push(new Pair(i, j));
				return placeQueen(n - 1, input, stack, 0, j + 1);
			}
			// }
		}

		if (!isFilled(input, j)) {
			if (!stack.isEmpty()) {
				Pair temp = stack.pop();
				input[temp.first][temp.second] = 0;
				placeQueen(n + 1, input, stack, temp.first + 1, temp.second);
			} else {
				throw new RuntimeException();
			}
		}
		return input;
	}

	private static boolean isFilled(int[][] input, int j) {
		for (int i = 0; i < input.length; i++) {
			if (input[i][j] == 1) {
				return true;
			}
		}
		return false;
	}

	private static boolean canPlace(int[][] input, int r, int c) {
		if (!(r < input.length && c < input.length)) {
			return false;
		}
		// Same Row
		for (int i = c; i >= 0; i--) {
			if (input[r][i] == 1) {
				return false;
			}
		}

		// same col
		for (int i = r; i >= 0; i--) {
			if (input[i][c] == 1) {
				return false;
			}
		}

		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
			if (input[i][j] == 1) {
				return false;
			}
		}
		for (int i = r, j = c; i < input.length && j >= 0; i++, j--) {
			if (input[i][j] == 1) {
				return false;
			}
		}

		return true;
	}

	public static List<List<String>> solveNQueens(int n) {
		int[][] input = new int[n][n];
		Stack<Pair> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			print(placeQueen(n, input, stack, i, 0));
			System.out.println("\n");
		}
		return null;
	}

	private static void print(int[][] placeQueen) {
		for (int i = 0; i < placeQueen.length; i++) {
			for (int j = 0; j < placeQueen.length; j++) {
				System.out.print(placeQueen[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		solveNQueens(8);
	}
}