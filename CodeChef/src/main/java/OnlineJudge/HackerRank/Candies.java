package OnlineJudge.HackerRank;

import java.util.Scanner;

public class Candies {

	public static void main(String[] args) {
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
}
