package OnlineJudge.HackerRank;

import java.util.Scanner;

public class SherlockAndPlanes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int j = 0; j < n; j++) {
			int x[] = new int[4];
			int y[] = new int[4];
			int z[] = new int[4];
			
			for (int i = 0; i < 4; i++) {
				x[i] = in.nextInt();
				y[i] = in.nextInt();
				z[i] = in.nextInt();
			}
			if(isSame(x) || isSame(y) || isSame(z)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
		}
	}
	
	private static boolean isSame(int []a){
		boolean isSame = true;
		int prev = a[0];
		for(int i=1;i<a.length;i++){
			if(prev != a[i]){
				return false;
			}
		}
		return isSame;
	}
}
