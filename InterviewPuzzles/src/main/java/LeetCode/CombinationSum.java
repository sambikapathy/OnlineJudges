package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
 find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
 */
public class CombinationSum {

	public static void main(String[] args) {
		int[] input = { 2, 3, 6, 7 };
		int target = 7;

		Arrays.sort(input);
		combinationSum(input, target, new ArrayList<>(), 0);
	}

	private static void combinationSum(int[] input, int target, List<Integer> result, int index) {

		if (target == 0) {
			System.out.println(result);
			return;
		}

		for (int i = index; i < input.length; i++) {
			if (i > 0 && input[i] == input[i - 1]) {
				continue;
			}
			if (target - input[i] >= 0) {
				result.add(input[i]);
				combinationSum(input, target - input[i], result, i);
				result.remove(result.size() - 1);
			}
		}
	}
}
