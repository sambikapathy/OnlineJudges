package OnlineJudge.HackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class Euler1_LargeSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		BigInteger total = new BigInteger("0");
		for(int i=0;i<tc;i++){
			BigInteger inp = new BigInteger(in.next());
			total = total.add(inp);
		}
		String result = (total.toString());
		System.out.println(result.substring(0, 10));
	
	}
}
