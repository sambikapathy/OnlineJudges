package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons {

	public int findMinArrowShots(int[][] points) {
		if (points == null || points.length == 0 || points[0].length == 0) {
			return 0;
		}
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		print(points);

		int count = 1;
		int end = points[0][1];
		for (int i = 1; i < points.length; i++) {
			int[] current = points[i];
			if (end >= current[0]) {
				end = Math.min(end, current[1]);
			} else {
				end = current[1];
				count++;
			}
		}
		return count;
	}

	private void print(int[][] points) {
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i][0] + "-" + points[i][1]);
		}

	}

	public static void main(String[] args) {
		int[][] input = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
		System.out.println(new MinimumNumberofArrowstoBurstBalloons().findMinArrowShots(input));
	}
}
