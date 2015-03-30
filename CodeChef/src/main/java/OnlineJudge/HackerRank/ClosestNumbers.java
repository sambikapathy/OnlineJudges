package OnlineJudge.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClosestNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		long smallest = Long.MAX_VALUE;
		List<Integer> results = new ArrayList<Integer>();
		
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				long value = Math.abs(a[i]-a[j]);
				if(value == smallest){
					results.add(a[i]);
					results.add(a[j]);
				}else if(value < smallest){
					smallest = value;
					results.clear();
					results.add(a[i]);
					results.add(a[j]);
				}else if(value > smallest){
					break;
				}
			}
		}
		for(int i : results){
			System.out.print(i +" ");
		}
		
	}
}
