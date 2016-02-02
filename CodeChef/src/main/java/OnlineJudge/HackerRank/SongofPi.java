package OnlineJudge.HackerRank;

import java.util.Scanner;

public class SongofPi {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		String lengths = "31415926535897932384626433833";
		for (int i = 0; i < n; i++) {
			String[] input = in.nextLine().split(" ");
			boolean isDone = true;
			for(int j=0;j<input.length;j++){
				if(lengths.charAt(j)-'0' != input[j].length() ){
					isDone = false;
					break;
				}
			}
			if(isDone){
				System.out.println("It's a pi song.");
			}else{
				System.out.println("It's not a pi song.");
			}
		}
	}
}
