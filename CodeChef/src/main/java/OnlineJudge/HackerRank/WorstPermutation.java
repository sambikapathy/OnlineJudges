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
		for(int i=0;i<(k<n?k:n);i++){
			int value = array[i];
			boolean isDone = false;
			int tempMax = value;
			int index = 0;
			for(int j=i+1;j<n;j++){
				if(array[j] > tempMax){
					tempMax = array[j];
					index = j;
					isDone = true;
				}
			}
			if(isDone && (tempMax > value)){
				array[index] = array[i];
				array[i] = tempMax;
			}else{
				//break;
			}
		}
		
		for(int i : array){
			System.out.print(i+" ");
		}
	}
}
