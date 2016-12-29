package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ShuffleAnArray {

	int[] orig = null;
	int[] current = null;
	Set<Integer> seen = new HashSet<>();

	Random random = new Random();

	public ShuffleAnArray(int[] nums) {
		orig = nums;
		current = Arrays.copyOf(nums, nums.length);

	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		current = Arrays.copyOf(orig, orig.length);
		seen.clear();
		random = new Random();
		return orig;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {

		// for(int i=0;i<orig.length;i++){
		int next = random.nextInt(orig.length);
		while (seen.contains((next = random.nextInt(orig.length)))) {

		}
		seen.add(next);
		int t = current[next];
		current[next] = current[0];
		current[0] = t;
		// }
		return current;
	}

	public static void main(String[] args) {
		int nums[] = { 11, 42, 43, 99, 23, 78 };
		ShuffleAnArray obj = new ShuffleAnArray(nums);
		for (int i = 0; i < 120; i++) {
			print(obj.shuffle());
		}
	}

	private static void print(int[] reset) {
		Arrays.stream(reset).forEach(entry -> System.out.print(entry + " "));
		System.out.println();

	}
}