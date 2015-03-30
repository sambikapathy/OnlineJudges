package OnlineJudge.HackerRank;

import java.util.Scanner;

public class StockMaximize {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int t = in.nextInt();
			int []input = new int[t];
			int []diff = new int[t];
			for(int j=0;j<t;j++){
				input[j] = in.nextInt();
			}
			diff[t-1] = input[t-1];
			for(int j=t-2;j>=0;j--){
				int value = diff[j+1] > input[j]?diff[j+1]:input[j];
				diff[j] = value;
			}
			
//			for(int j=0;j<t;j++){
//				System.out.print(diff[j]+" ");
//			}
			
			long sum = 0;
			for(int j=0;j<t;j++){
				sum+= diff[j] - input[j];
			}
			System.out.println(sum);
		}
	}
}
