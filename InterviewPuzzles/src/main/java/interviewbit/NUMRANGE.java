package interviewbit;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NUMRANGE {

	public int numRange(ArrayList<Integer> a, int b, int c) {
		int start = 0;
		int total = 0;
		int result = 0;
		for (int i = 0; i < a.size(); i++) {
			int t = total + a.get(i);
			if (t < b) {

			} else if (t == b) {
				result++;
				total = t;
			} else {
				if (t < c) {
					result++;
					total = t;
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(
				IntStream.of(new int[] { 10, 5, 1, 0, 2 }).boxed().collect(Collectors.toList()));
		int b = 6;
		int c = 8;
		new NUMRANGE().numRange(list, b, c);

	}
}
