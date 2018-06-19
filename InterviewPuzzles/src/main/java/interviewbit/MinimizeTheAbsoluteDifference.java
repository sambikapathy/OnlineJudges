package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimizeTheAbsoluteDifference {

	public int solve(List<Integer> A, List<Integer> B, List<Integer> C) {
		int f = 0, s = 0, t = 0;
		int result = Integer.MAX_VALUE;
		while (f < A.size() || s < B.size() || t < C.size()) {
			int t1 = f < A.size() ? A.get(f) : A.get(A.size() - 1);
			int t2 = s < B.size() ? B.get(s) : B.get(B.size() - 1);
			int t3 = t < C.size() ? C.get(t) : C.get(C.size() - 1);

			System.out.println(f + " " + s + " " + t);
			List<Integer> temp = new ArrayList<Integer>();
			if (f < A.size()) {
				temp.add(t1);
			}
			if (s < B.size()) {
				temp.add(t2);
			}
			if (t < C.size()) {
				temp.add(t3);
			}

			int min = Math.min(Math.min(t1, t2), t3);
			int max = Math.max(Math.max(t1, t2), t3);

			if (Math.abs(max - min) < result) {
				result = Math.abs(max - min);
			}
			if (temp.size() == 0) {
				break;
			}
			Collections.sort(temp);
			min = temp.get(0);
			if (f < A.size() && min == t1) {
				f++;
			} else if (s < B.size() && min == t2) {
				s++;
			} else if (t < C.size() && min == t3) {
				t++;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		// Integer[] A = { 1, 4, 5, 8, 10 };
		// Integer[] B = { 6, 9, 15 };
		// Integer[] C = { 2, 3, 6, 6 };
		Integer[] A = { 2 };
		Integer[] B = { 2 };
		Integer[] C = { 3 };
		System.out.println(
				new MinimizeTheAbsoluteDifference().solve(Arrays.asList(A), Arrays.asList(B), Arrays.asList(C)));
	}
}
