package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//ND
public class BurstBalloons {

	static HashMap<String, Integer> results = new HashMap<String, Integer>();

	public static int maxCoins(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : nums) {
			list.add(i);
		}
		return max(list);
	}

	public static int max(List<Integer> list) {
		String key = list.toString();
		if (results.containsKey(key)) {
			return results.get(key);
		}
		System.out.println(list.toString());

		if (list.size() == 1) {
			return list.get(0);
		}

		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			int temp = 0;
			if (i == 0) {
				temp = list.get(0) * list.get(1);
			} else if (i == list.size() - 1) {
				temp = list.get(i) * list.get(i - 1);
			} else {
				temp = list.get(i) * list.get(i - 1) * list.get(i + 1);
			}

			List<Integer> newList = new ArrayList<Integer>(list);
			newList.remove(i);

			int sum = temp + max(newList);
			if (sum > max) {
				max = sum;
			}
		}
		results.put(key, max);
		return max;
	}

	private static String getKey(List<Integer> list) {
		// StringBuilder sb = new StringBuilder();
		// for(int i : list){
		// sb.append(i+",");
		// }
		// return sb.toString();
		return list.toString();
	}

	public static void main(String[] args) {
		long s = System.currentTimeMillis();

		int[] input = { 8, 2, 6, 8, 9, 8, 1, };

		System.out.println(maxCoins(input));
		long e = System.currentTimeMillis();

		System.out.println((e - s) + "seconds ");

		int[] one = { 1, 2, 3 };
		// int [] two = Arrays.
	}
}
