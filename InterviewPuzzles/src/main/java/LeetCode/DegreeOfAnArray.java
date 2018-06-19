package LeetCode;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class DegreeOfAnArray {
	/*
	 * Input: [1, 2, 2, 3, 1] Output: 2 Explanation: The input array has a
	 * degree of 2 because both elements 1 and 2 appear twice. Of the subarrays
	 * that have the same degree: [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1],
	 * [1, 2, 2], [2, 2, 3], [2, 2] The shortest length is 2. So return 2.
	 * 
	 * 
	 * Input: [1,2,2,3,1,4,2] Output: 6
	 */

	private static int findDegree(int[] input) {
		final Map<Integer, Integer> count = new HashMap<>();
		Arrays.stream(input).forEach(item -> {
			if (count.containsKey(item)) {
				count.put(item, count.get(item) + 1);
			} else {
				count.put(item, 1);
			}
		});
		int max = -1;
		for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
			}
		}
		return max;
	}

	private static int findMinWindowWithDegree(int[] input, int degree) {
		int min = Integer.MAX_VALUE - 1;
		Map<Integer, Integer> count = new HashMap<>();
		int size = 0;
		int start = 0;
		for (int i = 0; i < input.length; i++) {
			int item = input[i];
			if (size + 1 > min) {
				int val = count.get(input[start]);
				count.put(input[start], val - 1);
				start++;
				size--;
			} else if (count.containsKey(item)) {
				count.put(item, count.get(item) + 1);
				size++;
				if (count.get(item) == degree) {
					// start removing items
					while (count.get(item) == degree) {
						if (size < min) {
							min = size;
						}
						int tv = count.get(input[start]);
						count.put(input[start], tv - 1);
						start++;
						size--;
					}
				}
			} else {
				count.put(item, 1);
				size++;
			}
		}
		return min;
	}

	private static int findMinWindowWithDegree_bruteForce(int[] input, int degree) {

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < input.length; i++) {
			Map<Integer, Integer> count = new HashMap<>();
			for (int j = i; j < input.length; j++) {
				int item = input[j];
				if (count.containsKey(item)) {
					if (count.get(item) + 1 == degree) {
						if (j - i < min) {
							min = j - i + 1;
						}
					}
					count.put(item, count.get(item) + 1);
				} else {
					count.put(item, 1);
				}

			}

		}
		return min;
	}

	public static void main(String[] args) {
		int[] input1 = IntStream.generate(() -> {
			try {
				return SecureRandom.getInstanceStrong().nextInt(20000);
			} catch (Exception e) {
				return 0;
			}
		}).limit(20000).toArray();

		int[] input = { 4, 4, 4 };
		int degree = findDegree(input);
		// System.out.println(degree);
		int min = findMinWindowWithDegree(input, degree);
		// int min = findMinWindowWithDegree_bruteForce(input, degree);
		System.out.println(min);
	}

}
