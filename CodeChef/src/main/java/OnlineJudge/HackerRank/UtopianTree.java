package OnlineJudge.HackerRank;

import java.util.Scanner;

public class UtopianTree {
//
//	2
//	0
//	1
	
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 int tc = in.nextInt();
		 for(int i=0;i<tc;i++){
			 int input = in.nextInt();
			 long start =1;
			 for(int j=1;j<=input;j++){
				 if(j%2==0){
					 start+=1l;
				 }else{
					 start*=2l;
				 }
			 }
			 System.out.println(start);
		 }
		 
   }
}
