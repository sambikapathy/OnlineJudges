package OnlineJudge.HackerRank;

import java.util.Scanner;

public class Cipher {

	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int [][]array = new int[k][n+k-1];
		String input = in.next();
		for (int i = 0; i < n+k-1; i++) {
			int result = input.charAt(i)-'0';
			for(int j=k-1;j>0;j--){
				result ^= array[j][i];
			}
			array[0][i] = result;
			int x = i+1;
			for(int j=1;j<k;j++){
				if(x<n+k-1)
				array[j][x++] = result;
			}
		}
		for(int j=0;j<k;j++){
		for(int i=0;i<n+k-1;i++){
//			System.out.print(array[j][i]);
		}
//		System.out.println();
		}
		for(int i=0;i<n;i++){
			System.out.print(array[0][i]);
		}
		
		//1001010
	}
}
