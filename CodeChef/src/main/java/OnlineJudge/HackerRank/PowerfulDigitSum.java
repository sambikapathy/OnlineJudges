package OnlineJudge.HackerRank;

import java.util.Scanner;

public class PowerfulDigitSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			int start = (int) Math.sqrt(a);
			int end = (int) Math.sqrt(b);
			int count = 0;
			for(int j = start;j<=end;j++){
				int val =  (int)Math.pow(j, 2);
				if(val >=a && val<=b){
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
