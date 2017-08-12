package OnlineJudge.HackerRank.DP;

public class EqualSum {

	// 1 2 5
	public static int numberOfOps(int[] input) {

		int[][] total = new int[100][input.length];
		boolean done = false;
		int[] values = new int[] { 1, 2, 5 };

		int index = min(input);

		while (!done) {

			boolean ready = true;
			for (int j = 0; j < input.length; j++) {
				if (index < input[j]) {
					ready = false;
					continue;
				}
				for (int i = 0; i < values.length; i++) {
					total[index + values[i]][j] = min(total[index][j] + 1, total[index + values[i]][j]);
				}
			}
			if (ready) {
				int sum = 0;
				int max = Integer.MIN_VALUE;
				for (int i = 0; i < input.length; i++) {
					if (total[index][i] == 0) {
						ready = false;
						break;
					}
					sum += total[index][i];
					if (max < total[index][i]) {
						max = total[index][i];
					}
				}
				if (ready && sum % (input.length - 1) == 0) {
					printArray(total, index);
					return max;
				}
			}
			index++;
		}

		return 0;
	}

	private static int min(int[] input) {
		int min = Integer.MAX_VALUE;
		for (int i : input) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}

	private static int min(int i, int j) {
		if (i == 0) {
			return j;
		}
		if (j == 0) {
			return i;
		}
		return i < j ? i : j;
	}

	private static void printArray(int[][] total, int index) {
		for (int i = 0; i <= index; i++) {
			System.out.print(i + " -> 3");
			for (int j = 0; j < total[0].length; j++) {
				System.out.print(total[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		int size = 4;
		int[] array = new int[size];
		// array = new int[] { 2, 2, 3, 7 };
		// 3
		// 1 5 5
		array = new int[] { 1, 5, 5 };
		// 3 3 3 8
		// 8 8 8 8

		System.out.println(numberOfOps(array));
	}
}
