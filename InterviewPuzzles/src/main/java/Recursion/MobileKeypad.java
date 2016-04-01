package Recursion;

import java.util.Arrays;

public class MobileKeypad {

	static int [][] keypad = {
//			{1,2,3},
//			{4,5,6},
//			{7,8,9},
//			{-1,0,-1}
			{1,1,1},
			{1,1,1},
			{1,1,1},
			{-1,1,-1}
	};
	
	private static int getCount(int [][]keypad , int count){
		int [][]total = new int[4][3];
		
		for(int i=0;i<4;i++)
			Arrays.fill(total[i], 1);
		total[3][0] = total[3][2] = -1;
		
		print(total);
		
		for(int i=1;i<count;i++){
			int [][]temp = copy(total);
			for(int j=0;j<4;j++){
				for(int k=0;k<3;k++){
					if(total[j][k] == -1){
						continue;
					}
					//left
					if(k>0 && j!=3){
						temp[j][k-1]+=total[j][k];
					}
					//right
					if(k<2 && j!=3){
						temp[j][k+1]+= total[j][k];
					}
					//top
					if(j>0){
						temp[j-1][k]+=total[j][k];
					}
					//bottom
					if(j<3 && temp[j+1][k] !=-1){
						temp[j+1][k]+=total[j][k];
					}
				}
			}
			total = copy(temp);
		}
		
		print(total);
		int result = 0;
		for(int i=0;i<4;i++){
			for(int j=0;j<3;j++){
				if(total[i][j] >0){
					result+=total[i][j]; 
				}
			}
		}
		return result;
	}
	
	private static void print(int[][] total) {
		for(int i=0;i<4;i++){
			for(int j=0;j<3;j++){
				System.out.print(total[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static int[][] copy(int[][] total) {
		int [][]temp = new int[4][3];
		for(int i=0;i<4;i++){
			for(int j=0;j<3;j++){
				temp[i][j] = total[i][j];
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(getCount(keypad , n));
	}
}
