package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class SplitIntoTwoSetsWithMinimalSum {

	public static void main(String[] args) {
		int []input = {10,5,19,20};
		System.out.println(minDiff(input, 0, new ArrayList(), new ArrayList()));
		System.out.println(count);
		/*
		 
		 10 200 300 400
		 1063623
		 2, 4 , 8 , 16 , 32 , 64 , 128
		 1 2 6 24 120 720 
		 7 49 350 
		 */
	}
	static int count = 0;
	public static int minDiff(int [] input , int index , List<Integer> one , List<Integer> two ){
		count++;
		int min = Integer.MAX_VALUE;
		print(one , two);
		if(index == input.length){
			int o = getSum(one);
			int t = getSum(two);
//			System.out.print(Math.abs(o-t) + "    ");
//			print(one , two);
			return Math.abs(o-t);
		}
		for(int i=index;i<input.length;i++){
			List<Integer> ot = new ArrayList(one);
			ot.add(input[index]);
			List<Integer> tt = new ArrayList(two);
			tt.add(input[index]);
			int temp =Math.min(minDiff(input, index+1 , one , tt ), minDiff(input, index+1, ot, two));
			if(temp < min){
				min = temp;
				
			}
		}
		return min;
	}

	static void print(List<Integer> a , List<Integer> b){
		for(int i : a){
			System.out.print(i+",");
		}
		
		System.out.print(" -> ");
		for(int i : b){
			System.out.print(i+",");
		}
		System.out.println();
	}
	private static int getSum(List<Integer> one) {
		int t = 0;
		for(int i : one){
			t+= i;
		}
		return t;
	}
	
}
