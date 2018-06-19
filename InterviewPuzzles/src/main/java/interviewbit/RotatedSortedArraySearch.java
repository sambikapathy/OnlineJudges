package interviewbit;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {

	public int search(final List<Integer> a, int b) {
		int s = 0, e = a.size() - 1;
		int result = -1;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (a.get(mid) == b) {
				return mid;
			} else if (a.get(mid) < b) {
				if (a.get(s) <= a.get(mid)) {
					s = mid + 1;
				} else if (a.get(mid) < a.get(e)) {
					if (a.get(e) >= b) {
						s = mid + 1;
					} else {
						e = mid - 1;
					}
				}
			} else {
				if (a.get(mid) < a.get(e)) {
					e = mid - 1;
				} else {
					if (a.get(e) > b) {
						s = mid + 1;
					} else {
						e = mid - 1;
					}
				}
			}
		}
		return -1;
	}

	//

	public static void main(String[] args) {
		Integer[] input = { 186, 192, 193, 202, 204, 2, 3, 6, 10, 11, 12, 17, 21, 28, 29, 30, 31, 32, 37, 38, 39, 40,
				41, 47, 49, 50, 51, 52, 55, 57, 58, 59, 60, 65, 67, 68, 71, 72, 74, 77, 78, 80, 82, 83, 88, 89, 90, 94,
				100, 107, 108, 109, 111, 112, 114, 115, 116, 118, 119, 121, 123, 124, 126, 129, 133, 134, 135, 137, 138,
				144, 147, 148, 150, 151, 154, 156, 159, 161, 163, 165, 166, 167, 168, 169, 174, 178, 180, 182, 183,
				185 };
		int b = 143;
		System.out.println(new RotatedSortedArraySearch().search(Arrays.asList(input), b));
	}
}
