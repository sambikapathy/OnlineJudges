package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class MedianOfArray {

	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

		return findMedianSortedArrays(a, b, 0, 1);
	}

	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b, int l, int r) {
		int t = a.size() + b.size();
		int am = a.size() / 2;
		int bm = b.size() / 2;

		if (a.get(am) < b.get(bm)) {

		} else if (a.get(am) > b.get(bm)) {

		} else {

		}
		return -1;

	}

	public static void main(String[] args) {
		List<Integer> a = getList(new int[] { 1, 2, 3 });
		List<Integer> b = getList(new int[] { 1, 2, 3 });

		System.out.println(new MedianOfArray().findMedianSortedArrays(a, b));
	}

	private static List<Integer> getList(int[] a) {
		List<Integer> list = new ArrayList<>();
		for (int i : a) {
			list.add(i);
		}
		return list;
	}
}
