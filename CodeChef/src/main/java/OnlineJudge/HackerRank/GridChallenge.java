package OnlineJudge.HackerRank;

import java.util.Scanner;

public class GridChallenge {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			int l = in.nextInt();
			char [][]input = new char[l][l];
			for(int j=0;j<l;j++){
				input[j] = in.next().toCharArray();
			}
			
			for(int j=0;j<l;j++){
				boolean isDone = false;
				while(!isDone){
					isDone = true;
					for(int k=0;k<l-1;k++){
						if(input[j][k] > input[j][k+1]){
							char t = input[j][k+1];
							input[j][k+1] = input[j][k];
							input[j][k] = t;
							isDone = false;
						}
					}
				}
			}
			
			boolean result = true;	
			for(int j=0;j<l;j++){
				for(int k=0;k<l-1;k++){
					if(input[k][j] > input[k+1][j]){
						result = false;
						break;
					}
				}
			}
			if(result){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}
