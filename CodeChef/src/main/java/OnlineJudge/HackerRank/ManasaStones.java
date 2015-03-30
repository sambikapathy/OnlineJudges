package OnlineJudge.HackerRank;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ManasaStones {

	private static final Set<Integer> set = new TreeSet<Integer>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		for(int i=0;i<count;i++){
			int n = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			int start = 0 , end = n-1;
			while(end >= 0){
				int total = start*a + end*b;
				set.add(total);
				start++ ; 
				end--;
			}
			for(int val : set){
				System.out.print(val+" ");
			}
			System.out.println();
			set.clear();
			
		}
	}
	
	
	public static void method1() {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		for(int i=0;i<count;i++){
			int n = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			printEnd(1, n, 0, a, b);
			for(int val : set){
				System.out.print(val+" ");
			}
			System.out.println();
			set.clear();
		}
	}
	
	public static void printEnd(int c , int n , int total , int a , int b){
		if(c==n){
			set.add(total);
		}else{
			printEnd(c+1, n, total+a, a, b);
			printEnd(c+1, n, total+b, a, b);
		}
	}
}
