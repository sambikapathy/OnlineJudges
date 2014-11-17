package OnlineJudge.HackerRank;

import java.util.Scanner;

public class Euler_LargestProduct {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for(int i=0;i<tc;i++){
			int n = in.nextInt();
			int k = in.nextInt();
			int []array = new int[n];
			String input = in.next();
			for(int j=0;j<n;j++){
				array[j] = (input.charAt(j))-'0';
			}
			long max = 0;
			for(int j=0;j<n-k;j++){
				long sum = 1;
				for(int x = 0;x<k;x++){
					sum*=array[j+x];
				}
				if(sum > max){
					max = sum;
				}
			}
			System.out.println(max);
		}
	
	}
}
