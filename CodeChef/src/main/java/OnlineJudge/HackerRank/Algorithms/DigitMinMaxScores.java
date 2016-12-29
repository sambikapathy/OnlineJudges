package OnlineJudge.HackerRank.Algorithms;

import java.util.HashMap;
import java.util.Scanner;

public class DigitMinMaxScores {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		long b = in.nextLong();
		
		if(b<100){
			System.out.println(0);
			return;
		}
		if(a<100){
			a=100;
		}
		method1(a, b);
		method2(a, b);
	}
	public static void method1(long a , long b){
		long prev = maxmin(a);
		long count = prev;
		for(long i = a+1;i<=b;i++){
			long temp = -1;
			
			long thou = i%1000l;
			long p = thou / 100;
			long c = (thou %100) / 10;
			long n = thou % 10;
			if(p < c && c<n){
				temp = prev-1;
			}else{
				temp = maxmin(i);
				prev = temp;
			}
			count+= temp;
		}
		System.out.println(count);
	}
	
	public static void method2(long a , long b){
		long count = 0;
		for(long i = a;i<=b;i++){
//			System.out.println(i);
			long temp = maxmin(i);
			count+= temp;
		}
		System.out.println(count);
	}

	HashMap<String,Integer> cache = new HashMap<>();
	
	private static long maxmin(long in) {
		long total = 0;
		char[] input = (in+"").toCharArray();
		for(int i=1;i<input.length-1;i++){
			char p = input[i-1];
			char c = input[i];
			char n = input[i+1];
			
			if(c<p && c<n){
				total++;
			}else if(c>p && c>n){
				total++;
			}
		}
		return total;
	}
}
