package OnlineJudge.HackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class Pairs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		int []a = new int[n];
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<n;i++){
			a[i] = in.nextInt();
			set.add(a[i]);
		}
		int total = 0;
		for(int i=0;i<n;i++){
			if(set.contains(a[i]-k)){
				total++;
			}
		}
		System.out.println(total);
	}
}
