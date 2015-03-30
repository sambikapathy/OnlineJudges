package OnlineJudge.HackerRank;

import java.util.Scanner;

public class MarbleCut {

	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int l = in.nextInt();
			int b = in.nextInt();
			if(l < b){
				int temp = b;
				b = l;
				l = temp;
			}
			int result = (l*b) % 3;
			if(result == 0){
				System.out.println("YES");
			}else{
				System.out.println("NO "+ result);
			}
		}
	}
}
