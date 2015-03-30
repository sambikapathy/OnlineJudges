package OnlineJudge.HackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Flowers {

	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		Integer c[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			c[i] = in.nextInt();
		}
		Arrays.sort(c , Collections.reverseOrder());
		long cost = 0;
		for(int i=0;i<n;i++){
			cost += ((i/k)+1)*c[i];
		}
		System.out.println(cost);
	}
}
