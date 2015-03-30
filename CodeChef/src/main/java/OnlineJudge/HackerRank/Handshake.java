package OnlineJudge.HackerRank;

import java.util.Scanner;

public class Handshake {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			int input = in.nextInt();
			System.out.println((input*(input-1))/2);
		}
	}
}
