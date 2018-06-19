package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		int start = -1;
		int end = -1;
		end = start = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != end + 1) {
				if (start != end) {
					result.add(start + "->" + end);
				} else {
					result.add(start + "");
				}
				end = start = nums[i];
			} else {
				end = nums[i];
			}
		}
		if (start != end) {
			result.add(start + "->" + end);
		} else {
			result.add(start + "");
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = { 0, 1, 3, 3, 5, 7, 8 };
		System.out.println(summaryRanges(input));
	}
}
