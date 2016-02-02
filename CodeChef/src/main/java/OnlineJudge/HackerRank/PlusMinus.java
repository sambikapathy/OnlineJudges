package OnlineJudge.HackerRank;

import java.util.Scanner;

public class PlusMinus {

	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
	double p =0 , m = 0 , z=0;
		for (int i = 0; i < n; i++) {
			int inp = in.nextInt();
			if(inp > 0){
				p++;
			}else if(inp == 0){
				z++;
			}else{
				m++;
			}
		}
		
		System.out.println(p/n);
		System.out.println(m/n);
		System.out.println(z/n);
		
	}
}
