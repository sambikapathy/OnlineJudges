package OnlineJudge.HackerRank;

import java.util.Scanner;

public class Candies {

	public static void main2(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []input = new int[n];
		int []sum = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = in.nextInt();
		}
		
		
		
		/*
		 s[i] = s[i-1]+1 , if a[i] > a[i-1]
		 s[i] = 1 , if a[i]<=a[i-1]
		 
		 1 2 3 
		 
		 3 2 1 2 3
		 1 0 -1 0 1
		 
		 
		 3 2 1 2 3
		  
		 */
		
		
		for(int i=0;i<n;i++){
			int start = 1;
			int count = 0;
			boolean isAdded = false;
			for(int j=i+1;j<n;j++){
				//2 4 2 6 1 7 8 9 2 1
				if(input[i] < input[j]){
					//5 4 3
					//1 2 3
					if(i-1>= 0 && input[i] > input[i-1]){
						count+= sum[i-1];
						isAdded = true;
					}else{
						count+= 1;
					}
					break;
				}else{
					count++;
				}
			}
				
			sum[i]= count;
//			if(!isAdded){
//				sum[i]+=1;
//			}
			
		}
		long total = 0;
		for(int i : sum){
			total+=i;
		}
		System.out.println(total);
	}
	
	
	
	//10 11 2 1
	//1 
	
	//backtracking and DP
	private static int candies(int []input){
		int n = input.length;
		int []result = new int[n];
		for(int i=0;i<n;){
			int count = 1;
			int pv = i==0?0:result[i-1];
			for(int j=i+1;j<n;j++){
				if(input[j]<input[j-1]){
					count++;
				}else{
					break;
				}
			}
			
			int s = 0;
			if(count > pv){
				s = count;
			}else if(count <= pv){
				if(input[i-1]< input[i]){
					s = pv+1;
				}else if(input[i-1] == input[i]){
					s=count;
				}else{
					s=count;
				}
			}
			result[i] = s;
			s = count-1;
			for(int k=1;k<count;k++){
				result[i+k] = s--;
			}
			//handle case wherer they are of equal value.
			i+=count;
		}
		int total = 0;
		for(int k : result){
			total+=k;
			System.out.print(k+" ");
		}
		System.out.println();
		return total;
	}
//	static int []input = {3,2,1,3,2};
//	static int []input = {2,1,1,9};
//	static int []input = {1,2,3,4};
	static int []input = {2,4,2,6,1,7,8,9,2,1};
	public static void main(String[] args) {
		System.out.println(candies(input));
	}
}
