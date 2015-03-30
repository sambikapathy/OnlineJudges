package OnlineJudge.HackerRank;

import java.util.Scanner;

public class CavityMap {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [][]input = new int[n][n];
		int [][]result = new int[n][n];
		for (int i = 0; i < n; i++) {
			String line = in.next();
			for(int j=0;j<n;j++){
				result[i][j] = input[i][j] = line.charAt(j)-'0';
				
			}
		}
		
		for(int i=1;i<n-1;i++){
			for(int j=1;j<n-1;j++){
				int value = input[i][j];
				if(input[i-1][j]< value 
						&& input[i][j-1]< value 
						&& input[i][j+1]< value 
						&& input[i+1][j]< value ){
					result[i][j] = -1;
				}else{
					result[i][j] = value;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for(int j=0;j<n;j++){
			 String value = (result[i][j]==-1)?"X":result[i][j]+"";
			 System.out.print(value);
			}
			System.out.println();
		}
		
		
	}
}
