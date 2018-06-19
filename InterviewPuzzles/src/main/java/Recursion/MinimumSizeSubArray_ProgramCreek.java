package Recursion;

public class MinimumSizeSubArray_ProgramCreek {

	static int count = 0;

	public static void main(String[] args) {
		int[] input = { 2, 3, 2, 2, 4, 3, 2, 3, 2, 2, 4, 3, 2, 3, 2, 2, 4, 3 };
		int s = 7;
		System.out.println(minSubArrayBruteForce(input, s));
		System.out.println(" --> " + count);
		count = 0;
		System.out.println(minSubArray(input, s));
		System.out.println(" --> " + count);
	}

	private static int minSubArray(int[] input, int target) {

		int l = 0;
		int r = 0;
		int min = Integer.MAX_VALUE;
		int temp = 0;
		while (l < input.length) {

			for (r = l; r < input.length; r++) {
				count++;
				if (temp + input[r] > target) {
					while (temp + input[r] > target) {
						temp -= input[l];
						l++;
					}
				}
				temp += input[r];
				if (temp == target) {
					min = Math.min(min, r - l + 1);
				}
			}
			if (r >= input.length) {
				break;
			}
		}
		return min;
	}

	private static int minSubArrayBruteForce(int[] input, int target) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < input.length; i++) {
			int temp = 0;
			for (int j = i; j < input.length; j++) {
				count++;
				temp += input[j];
				if (temp == target) {
					min = Math.min(min, j - i + 1);
				} else if (temp > target) {
					break;
				}
			}
		}
		return min;
	}
}
