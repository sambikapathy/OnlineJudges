package OnlineJudge.HackerRank;

import java.util.Scanner;

public class BricksGame {

	/*
	
	
	
You and your friend decide to play a game using a stack consisting of N bricks. 
In this game, you can alternatively remove 1, 2 or 3 bricks from the top, 
and the numbers etched on the removed bricks are added to your score. 
You have to play so that you obtain the maximum possible score. 
It is given that your friend will also play optimally and you make the first move.	
	
	
	 Sample Input

2
5
999 1 1 1 0
5
0 1 1 1 999
Sample Output

1001
999
	 */

	static int []input = {999,1,1,1,0};
	
	public static int bricksRec(int []input, int index){
		if(index == input.length){
			return 0;
		}
		return -1;
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int []input = new int[n];
			for(int j=0;j<n;j++){
				input[j] = in.nextInt();
			}
			
		}
	}
}
