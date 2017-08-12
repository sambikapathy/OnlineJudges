package LeetCode;

import java.util.Arrays;

/**
 * 
 * Given [1,2,0] return 3, and [3,4,-1,1] return 2. [2,4,6] -> 1 1,2,0 -> -1 -2
 * -1
 * 
 * [1] -> 2
 * 
 * 3,4,-1,1 -> 3,0,0,1 3,-1,0,-1
 * 
 * 
 */
public class FirstMissingPositive {

	// use aux array and keep setting the value..iterate thru aux array and
	// print result

	public int firstMissingPositive2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0 || nums[i] > nums.length) {
				nums[i] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			int key = Math.abs(nums[i]);
			if (key < nums.length) {
				int val = nums[key];
				if (val > 0) {
					nums[key] = val * -1;
				} else if (val == 0) {
					nums[key] = -1;
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0) {
				return i;
			} else if (nums[i] < 0) {
				max = i;
			}
		}
		if (max == Integer.MIN_VALUE) {
			return 1;
		}
		return max + 1;
	}

	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}
		int[] temp = new int[nums.length];
		for (int i : nums) {
			if (i != 0 && i <= nums.length) {
				temp[i - 1] = 1;
			}
		}

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 0) {
				return i + 1;
			}
		}
		return temp.length + 1;

	}

	/*
	 * If the datastructure can be mutated in place and supports random access
	 * then you can do it in O(N) time and O(1) additional space. Just go
	 * through the array sequentially and for every index write the value at the
	 * index to the index specified by value, recursively placing any value at
	 * that location to its place and throwing away values > N. Then go again
	 * through the array looking for the spot where value doesn't match the
	 * index - that's the smallest value not in the array. This results in at
	 * most 3N comparisons and only uses a few values worth of temporary space.
	 * 
	 * 
	 */

	public static void main(String[] args) {
		// int[] nums = new int[] { 1, 2, 0 };
		// int[] nums = new int[] { 2, 4, 6 };
		int[] nums = new int[] { 1 };

		System.out.println("$" + new FirstMissingPositive().firstMissingPositive(nums));
		Arrays.stream(nums).forEach(i -> System.out.print(i + " "));
	}
}
