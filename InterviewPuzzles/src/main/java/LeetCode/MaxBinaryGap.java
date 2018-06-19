package LeetCode;

public class MaxBinaryGap {

	private static int getGap_linear(int input) {
		int max = 0;
		int prev = -1;
		int index = 0;
		while (input > 0) {
			int val = input & 1;
			if (val > 0) {
				if (prev != -1) {
					if (index - prev > max) {
						max = index - prev;
					}
				}
				prev = index;
			}
			index++;
			input = input >> 1;
		}
		// 10110
		return max > 0 ? max - 1 : 0;
	}

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			// System.out.println(Integer.toBinaryString(i) + "->" +
			// getGap_linear(i));
			System.out.println(i + "->" + (i & -i) + "->" + (int) Math.log((i & -i)));
			// System.out.println(Integer.toBinaryString(8));
			// System.out.println(Integer.toBinaryString(~8));
			// System.out.println(Integer.toBinaryString(-8));
		}

	}
}
