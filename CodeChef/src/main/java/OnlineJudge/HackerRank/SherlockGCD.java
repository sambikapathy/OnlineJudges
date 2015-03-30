package OnlineJudge.HackerRank;

import java.util.Scanner;

public class SherlockGCD {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			int s = in.nextInt();
			int []array = new int[s];
			for(int j=0;j<s;j++){
				int val = in.nextInt();
				if(val %2 ==0){
					val = 2;
				}
				array[j] = val;
			}
			boolean isDone = false;
			for(int j=0;j<s && !isDone;j++){
				for(int k=j+1;k<s;k++){
					if(getGCD(array[j], array[k])==1){
						System.out.println("YES");
						isDone = true;
						break;
					}
				}
			}
			if(!isDone){
				System.out.println("NO");
			}
		}
	}
	
	
	private static int getGCD(int x , int y){
		while(y!=0){
			int temp = y;
			y = x % y;
			x = temp;
		}
		return x;
		
	}
}
