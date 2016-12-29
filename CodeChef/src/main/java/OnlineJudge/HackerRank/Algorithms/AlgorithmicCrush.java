package OnlineJudge.HackerRank.Algorithms;

import java.util.Scanner;

public class AlgorithmicCrush {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		long []array = new long[n+1];
		
		for(int i=0;i<m;i++){
			int s = in.nextInt();
			int e = in.nextInt();
			long v = in.nextLong();
			
			array[s]+=v;
			if(e+1 <= n){
				array[e+1]-=v;
			}
		}
		long  max = 0;
		long curr = 0;
		for(int i=1;i<=n;i++){
			curr+= array[i];
			if(curr > max){
				max = curr;
			}
		}
		
		System.out.println(max);
	}
}
