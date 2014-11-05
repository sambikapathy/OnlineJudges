package OnlineJudge.HackerRank;

import java.util.Scanner;

public class LoveLetter {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 int tc = in.nextInt();
		 for(int i=0;i<tc;i++){
			 String input = in.next();
			 int start = 0 , end = input.length()-1;
			 int count = 0;
			 while(start < end){
				 char a = input.charAt(start);
				 char b = input.charAt(end);
				 if(a==b)
					 ;//continue;
				 else
					 count+=Math.abs(a-b);
				 start++ ; end--;
			 }
			 System.out.println(count);
		 }
	}
}
