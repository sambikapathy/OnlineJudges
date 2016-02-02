package OnlineJudge.HackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class Averybigsum {

	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		BigInteger total = new BigInteger("0");
		for (int i = 0; i < n; i++) {
			total = total.add(new BigInteger(in.nextInt()+""));
		}
		System.out.println(total.toString());
	}
}
