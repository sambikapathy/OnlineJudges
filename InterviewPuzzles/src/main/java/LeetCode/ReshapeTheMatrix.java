package LeetCode;

import java.util.Arrays;

public class ReshapeTheMatrix {

	public int[][] matrixReshape(int[][] nums, int r, int c) {

		if (nums.length * nums[0].length != r * c) {
			return nums;
		}

		int[][] result = new int[r][c];
		int index = 0;
		int cl = nums[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i][j] = nums[index / cl][index % cl];
				index++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] nums = { { 1, 2 }, { 3, 4 } };
		int[][] matrixReshape = new ReshapeTheMatrix().matrixReshape(nums, 1, 4);
		System.out.println(Arrays.deepToString(matrixReshape));
		;
		;
	}
}
