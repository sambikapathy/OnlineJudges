package OnlineJudge.HackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
			int n = in.nextInt();
			int k = in.nextInt();
			int input [] = new int[n];
			for(int j=0;j<n;j++){
				input[j] = in.nextInt();
			}
			Arrays.sort(input);
			int []result = new int[k+1];
			result[0] = 1;
			int max = 0;
			for(int x=1;x<k+1;x++){
				for(int y=0;y<n;y++){
					int v = input[y];
					if(v > x){
						break;
					}
					if(result[x-v] > 0){
						result[x] = 1;
						max = x;
						break;
					}
				}
			}
			System.out.println(max);
		}
	}
}
