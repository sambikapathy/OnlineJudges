package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestIncreasingSequence {

	/*
	 * Both DP and recursion for this
	 */

	private int lisDp(Integer[] inpArray) {
		int[] result = new int[inpArray.length];
		result[0] = 1;
		for (int i = 1; i < inpArray.length; i++) {
			int max = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (inpArray[i] > inpArray[j] && result[j] + 1 > max) {
					max = result[j] + 1;
				}
			}
			result[i] = max;
		}
		int max = result[0];
		for (int i : result) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

	public Map<Wrapper, Integer> cache = new HashMap<>();

	class Wrapper {
		int index;
		List<Integer> temp;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + index;
			result = prime * result + ((temp == null) ? 0 : temp.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Wrapper other = (Wrapper) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (index != other.index)
				return false;
			if (temp == null) {
				if (other.temp != null)
					return false;
			} else if (!temp.equals(other.temp))
				return false;
			return true;
		}

		public Wrapper(int i, List<Integer> t) {
			index = i;
			temp = t;
		}

		private LongestIncreasingSequence getOuterType() {
			return LongestIncreasingSequence.this;
		}
	}

	private int lisRec(List<Integer> input, int index, List<Integer> temp) {
		Wrapper wrapper = new Wrapper(index, temp);
		if (cache.containsKey(wrapper)) {
			return cache.get(wrapper);
		}
		if (index >= input.size()) {
			// System.out.println(temp);
			cache.put(wrapper, temp.size());
			return temp.size();
		}
		int max = Integer.MIN_VALUE;
		for (int i = index; i < input.size(); i++) {
			// List<Integer> result = temp;
			int t1 = lisRec(input, i + 1, temp);
			int t2 = t1;
			if (temp.isEmpty() || temp.get(temp.size() - 1) < input.get(i)) {
				temp.add(input.get(i));
				t2 = lisRec(input, i + 1, temp);
				temp.remove(input.get(i));
			}
			max = Math.max(max, Math.max(t1, t2));
		}
		return max;
	}

	public static void main(String[] args) {
		Integer[] inpArray = { 50, 3, 10, 7, 40, 80, 50, 3, 10, 7, 40, 80, 50, 3, 10, 7, 40, 80, 50, 3, 10, 7, 40, 8050,
				3, 10, 7, 40, 80, 50, 3, 10, 7, 40, 80, 50, 3, 10, 7, 40, 8050, 3, 10, 7, 40, 8050, 3, 10, 7, 40, 8050,
				3, 10, 7, 40, 80 };
		List<Integer> input = Arrays.asList(inpArray);

		LongestIncreasingSequence lis = new LongestIncreasingSequence();
		long s = System.currentTimeMillis();
		System.out.println(lis.lisDp(inpArray));
		// System.out.println(lis.lisRec(new ArrayList<Integer>(input), 0, new
		// ArrayList<Integer>()));
		System.out.println(System.currentTimeMillis() - s);
	}
}
