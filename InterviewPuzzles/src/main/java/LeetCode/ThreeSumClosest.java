package LeetCode;

import java.util.Arrays;

/**
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */
public class ThreeSumClosest {

	// can it contain duplicates or negatove numners
	public static int threeSumClosest(int[] nums, int target) {
		int result = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int s = i + 1;
			int e = nums.length - 1;
			while (s < e) {
				int sum = Math.abs(nums[s] + nums[e] + nums[i]);
				if (Math.abs(sum - target) < result) {
					result = sum - target;
				} else if (sum > target) {
					e--;
				} else {
					s++;
				}

			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 8, 16, 32, 64, 128 };
		int target = 82;
		System.out.println(threeSumClosest(array, target));
	}
}
