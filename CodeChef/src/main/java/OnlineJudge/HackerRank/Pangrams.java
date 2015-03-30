package OnlineJudge.HackerRank;

import java.util.Scanner;

public class Pangrams {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine().toLowerCase();
		int []index = new int[26];
		int count = 0;
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)==' ') continue;
			int val = input.charAt(i)-'a';
			if(index[val]==0){
				index[val]=1;
				count++;
			}
			
			if(count==26){
				System.out.println("pangram");
				break;
			}
		}
		if(count!=26){
			System.out.println("not pangram");
		}
		
	}
}
