package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import LeetCode.MergeIntervals.Interval;

public class MeetingRooms2 {

	public static int minMeetingRooms(Interval[] intervals) {
		Arrays.sort(intervals);
		return -1;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 2, 3, 1, 5, 2, 8, 9, 12 };
		List<Interval> list = new ArrayList<>();
		for (int i = 0; i < input.length; i += 2) {
			list.add(new Interval(input[i], input[i + 1]));
		}
		System.out.println(minMeetingRooms(list.toArray(new Interval[] {})));
	}
}
