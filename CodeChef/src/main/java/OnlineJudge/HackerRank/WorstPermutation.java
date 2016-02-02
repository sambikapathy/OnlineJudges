package OnlineJudge.HackerRank;

import java.util.Scanner;

public class WorstPermutation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int []array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		int swaps = 0;
		int maxSwaps = (k<n?k:n);
		for(int i=0; i<n && swaps < maxSwaps;i++){
			int value = array[i];
			int tempMax = value;
			int index = 0;
			for(int j=i+1;j<n;j++){
				if(array[j] > tempMax){
					tempMax = array[j];
					index = j;
				}
			}
			if( (tempMax > value)){
				array[index] = array[i];
				array[i] = tempMax;
				swaps++;
			}else{
				//break;
			}
		}
		
		for(int i : array){
			System.out.print(i+" ");
		}
	}
}
