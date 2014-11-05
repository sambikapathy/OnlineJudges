package OnlineJudge.HackerRank;

import java.util.Scanner;

public class HalloweenParty {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for(int i=0;i<tc;i++){
			int input = in.nextInt();
			long val = (int) Math.ceil(input/2.0);
			if(input%2==0){
				System.out.println(val*val);
			}else{
				System.out.println(val*(val-1));
			}
		}
	}
}
