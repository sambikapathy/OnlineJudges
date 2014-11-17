package OnlineJudge.HackerRank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Euler1_Multiples {

	private void method1(){
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for(int i=0;i<tc;i++){
			long input = in.nextLong();
			Set<Long> set = new HashSet<Long>();
			long start = 3;
			long index = 1;
			while((start*index) < input){
				set.add(start*index++);				
			}
			start = 5;
			index=1;
			while((start*index) < input){
				set.add(start*index++);				
			}
			long sum = 0;
			for(Long val : set){
				sum+=val;
			}
			System.out.println(sum);
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for(int i=0;i<tc;i++){
			long input = in.nextLong();
			int start = 3;
			long sum =0;
			while(start<input){
				if(start%3==0 || start%5==0){
					sum+=start;
				}
				start++;
			}
			System.out.println(sum);
		}
	
	}
}
