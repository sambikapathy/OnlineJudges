package OnlineJudge.HackerRank;

import java.util.Scanner;

public class TheMaximumSubarray {
/*
 2 
4 
1 2 3 4
6
2 -1 2 3 4 -5
 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			int m = in.nextInt();
			int []input = new int[m];
			for(int j=0;j<m;j++){
				input[j] = in.nextInt();
			}
			int max[] = new int[m];
			int cmax[] = new int[m];
			max[0] = input[0];
			cmax[0] = input[0];
//			int cmax = input[0];
//			int result = cmax;
			for(int j=1;j<m;j++){
				int value = input[j];
				if(value+max[j-1] > max[j-1]){
					if(value+max[j-1]>value){
						max[j] = max[j-1]+value;
 					}else{
 						max[j] = value;
 					}
				}else{
					max[j] = max[j-1];
				}
				
				if(value+cmax[j-1] > value){
					cmax[j] = value+cmax[j-1];
				}else{
					cmax[j] = value;
				}
				
				
			}
			int result = cmax[0];
			for(int j=1;j<cmax.length;j++){
				if(result < cmax[j]){
					result = cmax[j];
				}
			}
			System.out.println(result +" "+max[m-1]);
			
		}
	}
}
