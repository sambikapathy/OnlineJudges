package OnlineJudge.HackerRank;

import java.util.Scanner;

public class ServiceLane {

//	8 5
//	2 3 1 2 3 2 3 3
//	0 3
//	4 6
//	6 7
//	3 5
//	0 7
	
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 int size = in.nextInt();
		 int tc = in.nextInt();
		 int []width = new int[size];
		 for(int i=0;i<size;i++){
			 width[i] = in.nextInt();
		 }
		 for(int i=0;i<tc;i++){
			 int start = in.nextInt();
			 int end = in.nextInt();
			 int min = Integer.MAX_VALUE;
			 for(int j=start;j<=end;j++){
				 if(width[j] < min)
					 min = width[j];
			 }
			 System.out.println(min);
		 }
		 
    }
}
