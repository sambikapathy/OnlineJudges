package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 *
 * 
 * 4,2 1,2 1,3 1,4
 * 
 * 4,3 123 124 134 234
 * 
 */
public class Combinations {
	/*
	 * 1,2,3,4 1100 1010 1001 0110 0101 0011
	 */
	public void combine3(int n, int k, int start, List<Integer> temp, List<List<Integer>> result) {
		if (temp.size() == k) {
			result.add(temp);
			return;
		}
		if (temp.size() + (n - start) + 1 < k) {
			return;
		}
		for (int i = start; i <= n; i++) {
			List<Integer> temp1 = new ArrayList<>(temp);
			temp1.add(i);
			combine3(n, k, i + 1, temp1, result);
		}
	}

	public List<List<Integer>> combine2(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i <= n - k; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(i + 1);
			result.add(list);
		}
		boolean isDone = false;
		while (!isDone) {
			isDone = true;
			List<List<Integer>> swap = new ArrayList<>();
			for (List<Integer> temp : result) {

				int last = temp.get(temp.size() - 1);
				// additional check to skip if we cannot achieve
				// i < n , k , temp.size()
				for (int i = last + 1; i <= n && temp.size() < k; i++) {
					List<Integer> newList = new ArrayList<>(temp);
					newList.add(i);
					swap.add(newList);
					isDone = false;
				}
			}
			if (!isDone) {
				result = swap;
			}
			if (swap.size() > 0 && swap.get(0).size() == k) {
				isDone = true;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		// List<List<Integer>> combine = new Combinations().combine2(10, 2);
		List<List<Integer>> combine = new ArrayList<>();
		new Combinations().combine3(1000, 500, 0, new ArrayList<>(), combine);

		combine.forEach(list -> {
			list.forEach(i -> System.out.print(i + " "));
			System.out.println();
		});
	}

	private List<List<Integer>> combine(int i, int j) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		combine(i, 1, j, result, new ArrayList<Integer>());
		return result;
	}

	private void combine(int n, int start, int k, List<List<Integer>> result, List<Integer> temp) {

		if (start > n) {
			return;
		}
		if (k == 0) {
			result.add(temp);
			return;
		}

		combine(n, start + 1, k, result, new ArrayList<>(temp));
		ArrayList<Integer> list = new ArrayList<>(temp);
		list.add(start);
		combine(n, start + 1, k - 1, result, list);
	}
}
