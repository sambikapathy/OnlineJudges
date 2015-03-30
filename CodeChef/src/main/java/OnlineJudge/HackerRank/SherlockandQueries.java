package OnlineJudge.HackerRank;

import java.util.Scanner;

public class SherlockandQueries {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		long []a = new long[n];
		long []b = new long[m];
		long []c = new long[m];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextLong();
		}
		
		for(int i=0;i<m;i++){
			b[i] = in.nextLong();
		}
		for(int i=0;i<m;i++){
			c[i] = in.nextLong();
		}
		
		long mod = 1000000007;
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(j%b[i-1]==0){
					a[j-1] = (a[j-1] * c[i-1])%mod;
				}
			}
		}
		
		for(int i=0;i<n;i++){
			System.out.print(a[i]+" ");
		}
	}
}
