package OnlineJudge.HackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class ChiefHopper {

	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [] a = new int[n];
		
		long min = Integer.MAX_VALUE;
		long max = Integer.MIN_VALUE;
		BigInteger total = BigInteger.ZERO;
		for (int i = 0; i < n; i++) {
			int value = in.nextInt();
			a[i] = value;
			total= total.add(new BigInteger(value+""));
			if(value < min){
				min = value;
			}
			if(value > max){
				max = value;
			}
		}
		long avg = (int) Math.ceil(total.divide(new BigInteger(n+"")).doubleValue());
		/*
		 
		  if(a[i] > value){
					value-= (a[i]-value);
				}else{
					value+= (value-a[i]);
				}
				if(value < 0){
					isDone = false;
					break;
				}
		 */
		long start = 1;
		long end = max;
//		if(start == end){
//			start = end / 2;
//		}
		long best = 0;
		while(!(start > end)){
			BigInteger value = new BigInteger((start+end)/2+"");
			long mid = value.longValue();
			boolean isDone = true;
			for(int i=0;i<n;i++){
				BigInteger current = new BigInteger(a[i]+"");
				if(current.compareTo(value) > 0){
					value = value.subtract(current.subtract(value));
				}else{
					value = value.add(value.subtract(current));
				}
				if(value.compareTo(BigInteger.ZERO) < 0){
					isDone = false;
					break;
				}
			}
			
			if(isDone){
				best = mid;
				end = mid-1;
			}else{
				start = mid+1;
			}
			
		}
		
		System.out.println(best);
	}
}
