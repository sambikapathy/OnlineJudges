package OnlineJudge.HackerRank.DP;

import java.util.Arrays;
import java.util.HashSet;

public class CoinChangeProblem {

	//4 3
	//1 2 3
	//->4
	
	
	
	//10 4
//	2 5 3 6
	//->5
	 public static void main(String[] args) {
//	       Scanner in = new Scanner(System.in);
//			int total = in.nextInt();
//	        int n = in.nextInt();
//			int []input = new int[n];
//			for (int i = 0; i < n; i++) {
//				input[i] = in.nextInt();
//			}
		 int []input = {1,2,3};
		 int total = 4;
	     
		 coinChange(input, total);
		 coinChange2(input, total);
	        
	    }
	    /*
	     1 1 1
	     1 2
	     3
	     
	     1 1 1 1
	     1 1 2
	     1 3
	     2 2
	     */
	 public static int coinChange(int [] input , int total){
		 int n = input.length;
		 int []result = new int[total+1];
	        result[0] = 1;
	        HashSet<Integer> set = new HashSet<>();
	        for(int i : input){
	        	set.add(i);
	        }
	        for(int i=1;i<=total;i++){
	            for(int j=0;j<n;j++){
	            	int diff = i-input[j]; 
	                if(diff >=0 && (input[j]==diff || !(set.contains(diff) && input[j] > diff))){
	                    result[i]+= result[diff];
	                }
	            }
	        }
	        
	        for(int k:result){
	            System.out.print(k+" ");
	        }
	        System.out.println();
	        System.out.println(result[total]);
	        return result[total];
	 }
	 
	 public static int coinChange2(int [] input , int total){
		 int []result = new int[total+1];
		 result[0] = 1;
		 for(int i=0;i<input.length;i++){
			 for(int j=input[i];j<=total;j++){
				 result[j] += result[j-input[i]];
			 }
		 }
		 for(int k:result){
	            System.out.print(k+" ");
	        }
	        System.out.println();
		 return result[total];
	 }
}
