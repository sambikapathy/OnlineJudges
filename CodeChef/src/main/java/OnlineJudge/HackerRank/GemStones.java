package OnlineJudge.HackerRank;

import java.util.Scanner;

public class GemStones {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 int tc = in.nextInt();
		 String [] input = new String[tc];
		 for(int i=0;i<tc;i++){
			 input[i] = in.next();
		 }
		 
		 int total = 0;
		 for(int i=0;i<26;i++){
			 String a = ((char)('a'+i))+"";
			 int count = 0;
			 for(int j=0;j<tc;j++){
				 if(input[j].contains(a)){
					 count++;
				 }
			 }
			 if(count==tc){
				 total++;
			 }
		 }
		 System.out.println(total);
	}
}
