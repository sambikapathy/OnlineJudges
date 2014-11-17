package OnlineJudge.HackerRank;

import java.util.Scanner;

public class AlternatingCharacters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			String input = in.next();
			char c = input.charAt(0);
			int deletes = 0;
			for(int j=1;j<input.length();j++){
				char d = input.charAt(j);
				if(c!=d){
					c = d;
				}else{
					deletes++;
				}
			}
			System.out.println(deletes);
		}
	}
}
