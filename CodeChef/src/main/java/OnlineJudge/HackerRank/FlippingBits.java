package OnlineJudge.HackerRank;

import java.util.Scanner;

public class FlippingBits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			long input = in.nextLong();
			long start = 1;			
			for(int ii=1;ii<=32;ii++){
				input = input^start;
				start = start<<1;
			}
			System.out.println((long)input);
		}
	}
}
