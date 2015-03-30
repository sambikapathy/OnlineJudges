package OnlineJudge.HackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		long a = in.nextLong();
//		long b = in.nextLong();
//		long total = 0l;
		BigInteger a = new BigInteger(in.nextInt()+"");
		BigInteger b = new BigInteger(in.nextInt()+"");
		int n = in.nextInt();
		BigInteger total = new BigInteger("0");
		for (int i = 3; i <= n; i++) {
			total = a.add(b.multiply(b));
			a = b;
			b = total;
			//System.out.println(total.toString());
		}
		System.out.println(total);
	}
}
