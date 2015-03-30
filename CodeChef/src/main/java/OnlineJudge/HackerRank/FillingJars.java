package OnlineJudge.HackerRank;

import java.util.Scanner;

public class FillingJars {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long l = in.nextInt();
		long m = in.nextInt();
		long total = 0;
		for (long j = 0; j < m; j++) {
			long a = in.nextInt();
			long b = in.nextInt();
			long k = in.nextInt();
			total += (b - a + 1) * k;
		}
		System.out.println(total / l);
	}
	
	private static void print(){
		long start = 1000000;
		long total = 0;
		for(int i = 0 ; i< 100000;i++){
			total+= (2)*start;
		}
		System.out.println(total);
	}
}
