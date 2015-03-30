package OnlineJudge.HackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TwoArrays {

	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int []a = new int[n];
			Integer []b = new Integer[n];
			for(int j=0;j<n;j++){
				a[j] = in.nextInt();
			}
			for(int j=0;j<n;j++){
				b[j] = in.nextInt();
			}
			Arrays.sort(a);
			Arrays.sort(b,Collections.reverseOrder());
			boolean isDone = true;
			for(int j=0;j<n;j++){
				if(a[j]+b[j]<k){
					isDone = false;
					break;
				}
			}
			if(isDone){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}
