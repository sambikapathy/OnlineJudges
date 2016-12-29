package OnlineJudge.HackerRank.Algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class GridlandMetro {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		BigInteger result = new BigInteger("" + n).multiply(new BigInteger("" + m));
		Map<Integer, List<Pair>> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			int r = in.nextInt() - 1;
			int c1 = in.nextInt() - 1;
			int c2 = in.nextInt() - 1;

			List<Pair> pairs = null;
			if (map.containsKey(r)) {
				pairs = map.get(r);
			} else {
				pairs = new ArrayList<>();
				map.put(r, pairs);
			}

			pairs.add(new Pair(c1, c2));
			List<Pair> newPair = merge(pairs, 0);
			map.put(r, newPair);

		}
		List<BigInteger> response = new ArrayList<>();
		response.add(result);

		map.entrySet().stream().forEach(entry -> {
			BigInteger total = new BigInteger("0");

			final AtomicInteger temp = new AtomicInteger();

			entry.getValue().stream().forEach(item -> {
				temp.addAndGet(item.second - item.first + 1);
			});

			total = total.add(new BigInteger(temp + ""));

			BigInteger x = response.get(0).subtract(total);
			response.clear();
			response.add(x);

		});
		System.out.println(response.get(0).toString());
	}

	private static List<Pair> merge(List<Pair> pairs, int index) {
		if (index + 1 == pairs.size()) {
			return pairs;
		}

		Pair one = pairs.get(index);
		Pair two = pairs.get(index + 1);
		// 1,3 2,4
		// 1,3 4,5
		// 2,3 1,4
		// 1,4 2,3

		if (one.second < two.first) {
			return merge(pairs, index + 1);
		} else if (one.second == two.first) {
			one.second = two.second;
			pairs.remove(index + 1);
			pairs.remove(index);
			pairs.add(index, one);
			return merge(pairs, index);
		} else if (one.second > two.first) {
			if (one.second >= two.second) {
				pairs.remove(index + 1);
				return merge(pairs, index);
			} else {
				one.second = two.second;
				pairs.remove(index + 1);
				pairs.remove(index);
				pairs.add(index, one);
				return merge(pairs, index);
			}
		}
		return pairs;

	}

	static class Pair {
		public int first;
		public int second;

		public Pair(int f, int s) {
			first = f;
			second = s;
		}
	}
}
