package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	/*
	 * For example, given array S = [-1, 0, 1, 2, -1, -4], [-4,-1,-1,0,1,2] A
	 * solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
	 * 
	 */

	public static void main(String[] args) {
		// int[] input = { -1, 0, 1, 2, -1, -4 };
		int[] input = { 0, 0, 0, 0 };
		List<List<Integer>> threeSum = new ThreeSum().threeSum(input);
		threeSum.stream().forEach(list -> {
			list.stream().forEach(item -> System.out.print(item + " "));
			System.out.println();
		});

	}

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int total = nums[i] + nums[start] + nums[end];
				if (total == 0) {
					result.add(Arrays.asList(nums[i], nums[start], nums[end]));
					while (start < end && nums[start + 1] == nums[start++]) {
					}
					// break;
				} else if (total > 0) {
					end--;
				} else {
					start++;
				}
			}
		}
		return result;
	}
}
