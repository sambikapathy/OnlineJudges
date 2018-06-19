package LeetCode;

import java.util.Arrays;

public class CountingBits {

	static int[] input = { 0, 1, 1, 2, 1, 2, 2, 3 };

	public static void main(String[] args) {
		int[] countBits = new CountingBits().countBits(22);
		// Arrays.stream(countBits).forEach(id -> System.out.print(id));
		System.out.println(Arrays.toString(countBits));
	}

	public int[] countBits(int num) {
		if (num == 0) {
			return new int[] { 0 };
		}
		if (num == 1) {
			return new int[] { 0, 1 };
		}

		int[] result = new int[num + 1];
		result[0] = 0;
		result[1] = 1;
		for (int i = 2; i <= num;) {
			// power of two
			if ((i & i - 1) == 0) {
				// copy over elements
				int prev2 = i / 2;
				for (int j = i; j < i * 2 && j <= num; j++) {
					if (j < (i + prev2)) {
						result[j] = result[j - prev2];
					} else {
						result[j] = result[j - prev2] + 1;
					}
				}
			}
			i = i * 2;
		}
		return result;
	}
}
