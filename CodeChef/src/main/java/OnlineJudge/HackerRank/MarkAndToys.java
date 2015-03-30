package OnlineJudge.HackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {

	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int []input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = in.nextInt();
		}
		
		Arrays.sort(input);
		int count = 0 , index =0;
		while(k - input[index] > 0){
			count++;
			k -= input[index++];
		}
		System.out.println(count);
	}
}
