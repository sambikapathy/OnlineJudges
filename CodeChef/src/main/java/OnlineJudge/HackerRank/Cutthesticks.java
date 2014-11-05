package OnlineJudge.HackerRank;

import java.util.Scanner;

public class Cutthesticks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int []input = new int[tc];
		int min = Integer.MAX_VALUE;
		for(int i=0;i<tc;i++){
			input[i] = in.nextInt();
			if(min > input[i]){
				min = input[i];
			}
		}
		System.out.println(tc);
		
		while(true){
			int count = 0;
			int newMin = Integer.MAX_VALUE;
			for(int i=0;i<tc;i++){
				int val = input[i]-min;
				if(val==0){
					
				}else if(val > 0){
					count++;
					if(newMin > val){
						newMin = val;
					}
				}
				input[i] = val;
			}
			if(count==0){
				break;
			}
			min = newMin;
			System.out.println(count);
		}
	}

}
