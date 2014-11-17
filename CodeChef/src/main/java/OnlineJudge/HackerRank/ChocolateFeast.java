package OnlineJudge.HackerRank;

import java.util.Scanner;

public class ChocolateFeast {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }
    
    private static long Solve(int N, int C, int M){
        int total = N/C;
        int result = total;
        while(total >= M){
        	
        	result+= total/M;
        	total = total %M + total/M;
        }
        return result;
    }
}
