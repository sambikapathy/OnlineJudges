package OnlineJudge.HackerRank;

import java.util.Scanner;

public class QueensRevised {

	private static boolean findQueens(int count ,int n, int [][]array){
		if(count == n){
			return true;
		}
		//count++;
		for(int i = 0;i<n*n;i++){
			int r = i/n;
			int c = i%n;
			if(array[r][c] !=0){
				continue;
			}
			int [][]newArray = array.clone();
			fillArray(i, newArray , 1);
			newArray[r][c] = 99999;
			
			if(!findQueens(count+1, n, newArray)){
				fillArray(i, array, -1);
				array[r][c] = 0;
				continue;
			}
			else{
				//count++;
				array = newArray;
				return true;
			}
		}
		return false;
		
	}
	
//	private boolean isValid(){
//		
//	}
	
	private static void fillArray(int index , int [][]array , int value){
		int size = array.length;
		int i = index / size;
		int j = index % size;
		
		
		for(int x = 0;x < size;x++){
			array[i][x] += value;
		}
		for(int x = 0;x < size;x++){
			array[x][j] += value;
		}
		
		for(int x = 0;x < size;x++){
			array[i][x] += value;
		}
		int small = i < j ? i : j;
		int x = i-small;
		int y = j - small;
		while(x < size && y < size){
			array[x][y] += value;
			x++ ; y++;
		}
		
		// 1,2 0,3 2,1 3,0
		x = i ; y = j;
		while(x>=0 && y <size){
			array[x][y] += value;
			x--;y++;
		}
		
		x = i ; y = j;
		while(x < size && y >=0){
			array[x][y] += value;
			x++;y--;
		}
		
	}
	
	static void printArray(int [][]array){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length;j++){
				System.out.print(array[i][j]+"");
				if(array[i][j]==99999){
//					System.out.print(j+1+" ");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 12;
		for (int i = 11; i < n; i++) {
			int [][]array = new int[i][i];
			findQueens(0 , i , array);
			printArray(array);
		}
	}
}
