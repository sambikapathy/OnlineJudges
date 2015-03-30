package OnlineJudge.HackerRank;

import java.util.Scanner;

public class IceCreamParlor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			int m = in.nextInt();
			int k = in.nextInt();
			int []a = new int[k];
			for(int j=0;j<k;j++){
				a[j] = in.nextInt();
			}
			//Arrays.sort(a);
			boolean isDone = false;
			for(int x=0;x<k-1;x++){
				for(int y=x+1;y<k;y++){
					if(a[x]+a[y]==m){
						System.out.println((x+1)+" "+(y+1));
						isDone = true;
						break;
					}
				}
				if(isDone){
					break;
				}
			}
		}
	}
}
