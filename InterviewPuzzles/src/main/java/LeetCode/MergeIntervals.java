package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

	static class Interval implements Comparable<Interval> {
		public int start;
		public int end;

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}

		public Interval(int s, int e) {
			start = s;
			end = e;
		}
		@Override
		public int compareTo(Interval o) {
			if (this.start == o.start) {
				return this.end - o.end;
			} else {
				return this.start - o.start;
			}
		}
	}

	public static List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, (o1, o2) -> {
			if (o1.start == o2.start) {
				return o1.end - o2.end;
			} else {
				return o1.start - o2.start;
			}
		});

		List<Interval> result = new ArrayList<>();
		Interval start = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval current = intervals.get(i);
			if (start.end < current.start) {
				result.add(start);
				start = current;
			} else if (start.end >= current.start) {
				// 1-4 4-5
				// 1-4 2-5
				start.end = Math.max(start.end, current.end);
			} else {
				// 1-5 3-10
				System.out.println("ERROR");
			}
		}
		result.add(start);
		return result;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 2, 3, 1, 5, 2, 8, 9, 12 };
		List<Interval> list = new ArrayList<>();
		for (int i = 0; i < input.length; i += 2) {
			list.add(new Interval(input[i], input[i + 1]));
		}
		// Collections.sort(list);
		// list.stream().forEach(System.out::println);
		merge(list).stream().forEach(System.out::println);
	}
}
