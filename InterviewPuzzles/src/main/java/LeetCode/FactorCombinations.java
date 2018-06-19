package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

	public static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		recHelper(n, 1, 2, result, new ArrayList<Integer>());
		return result;
	}

	private static void recHelper(int input, int product, int start, List<List<Integer>> result,
			List<Integer> current) {
		if (product > input || start > input) {
			return;
		}
		if (product == input) {
			result.add(new ArrayList<>(current));
			return;
		}

		for (int i = start; i < input; i++) {
			if (i * product > input) {
				break;
			}

			if (input % i == 0) {
				current.add(i);
				recHelper(input, product * i, i, result, current);
				current.remove(current.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int input = 32;
		System.out.println(getFactors(input));
	}
}
