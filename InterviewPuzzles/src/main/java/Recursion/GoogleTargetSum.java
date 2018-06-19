package Recursion;

public class GoogleTargetSum {
	// https://careercup.com/question?id=5724941042319360
	/**
	 * 
	 * Target sum is 15.
	 * 
	 * An int array is { 1, 3, 4, 5, 6, 15 }.
	 * 
	 * Then all satisfied subsets whose sum is 15 are as follows:
	 * 
	 * 15 = 1+3+5+6 15 = 4+5+6 15 = 15
	 */

	// https://careercup.com/page?pid=salse-force-interview-questions

	private static void targetSum(int[] input, int target) {
		int count = (int) Math.pow(2, input.length);
		for (int i = 0; i < count; i++) {
			int temp = i;
			int total = 0;
			int index = 0;
			String prefix = "";
			while (temp > 0) {
				if ((temp & 1) != 0) {
					temp = temp >> 1;
					int temp2 = total + input[index];
					if (temp2 == target && temp == 0) {
						System.out.println(prefix + index + " -> " + i);
					} else if (temp2 > target) {
						break;
					} else {
						prefix += index;
						total = temp2;
					}
				} else {
					temp = temp >> 1;
				}
				index++;
			}
		}

	}

	public static void main(String[] args) {
		int[] input = { 1, 3, 4, 5, 6, 15 };
		int target = 15;
		targetSum(input, target);

		System.out.println();
	}
}
