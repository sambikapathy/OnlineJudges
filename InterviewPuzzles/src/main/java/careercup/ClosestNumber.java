package careercup;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ClosestNumber {

	// return the difference between closest and target
	public static int findClosest(int[] input, int target) {
		System.out.println(Arrays.toString(input));
		int s = 0, e = input.length - 1;
		int result = Integer.MAX_VALUE;
		while (s < e) {
			int mid = s + (e - s) / 2;
			if (input[mid] == target) {
				return input[mid];
			} else if (input[mid] < target) {
				s = mid + 1;
				result = Math.min(result, target - input[mid]);
			} else {
				e = mid - 1;
				result = Math.min(result, input[mid] - target);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = IntStream.generate(() -> {
			try {
				return SecureRandom.getInstanceStrong().nextInt(20);
			} catch (Exception e) {
				return 0;
			}
		}).limit(10).toArray();

		Arrays.sort(array);
		System.out.println(findClosest(array, 25));
	}
}
