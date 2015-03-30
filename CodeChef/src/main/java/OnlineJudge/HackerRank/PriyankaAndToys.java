package OnlineJudge.HackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class PriyankaAndToys {

	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		
		int total = 1;
		int last = a[0];;
		for(int i=1;i<n;i++){
			if(a[i]-last<=4){
				
			}else{
				last  = a[i];
				total++;
			}
		}
		System.out.println(total);
	}
}
