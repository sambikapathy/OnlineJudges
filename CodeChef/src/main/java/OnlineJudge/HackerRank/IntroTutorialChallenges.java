package OnlineJudge.HackerRank;

import java.util.Scanner;

public class IntroTutorialChallenges {

//	4
//	6
//	1 4 5 7 9 12
//	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		for(int i=0;i<m;i++){
			int input = in.nextInt();
			if(input == n){
				System.out.println(i);
				break;
			}
		}
	}
}
