package OnlineJudge.HackerRank;

import java.util.Scanner;

public class Euler1_SmallestMultiple {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for (int i = 0; i < tc; i++) {
			long sum = 1;
			int n = in.nextInt();
			int[] array = new int[n+1];
			for (int j = 1; j <= n; j++) {
				array[j] = j;
			}
			for(int j=2;j<=n;j++){
				for(int k=1;j*k<=n;k++){
					int val = j*k;
					if(array[val]%array[k]==0){
						array[val]/= array[k];
					}
				}
			}
			long result = 1;
			for(int x=1;x<n+1;x++){
				result*=array[x];
			}
			System.out.println(result);
		}
	}
}
