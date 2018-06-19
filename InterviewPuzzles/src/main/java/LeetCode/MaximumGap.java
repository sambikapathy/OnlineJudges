package LeetCode;

import java.util.Arrays;

public class MaximumGap {

	public static int maxGap(int[] input) {
		Arrays.stream(input).forEach(no -> System.out.println(Integer.toBinaryString(no)));
		return -1;
	}

	public static void main(String[] args) {
		int[] input = { 2, 20, 24 };
		System.out.println(maxGap(input));
	}
}
