package OnlineJudge.HackerRank;

import java.util.Scanner;
/*
 2
2 2
6 9
 */
public class Restaurant {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int l = in.nextInt();
			int b = in.nextInt();
			int val = l < b ? l : b;
			int max = 0;
			int result = 0;
			for(int j=1;j<=val;j++){
				if(l%j==0 && b%j==0){
					if(j > max){
						max = j;
						result = l/j * b/j;
					}
				}
			}
			System.out.println(result);
		}
	}
}

