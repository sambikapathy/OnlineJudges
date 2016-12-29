package OnlineJudge.HackerRank.GraphTheory;

import java.util.Scanner;

public class SnakesandLaddersTheQuickestWayUp {

	/*
2
3
32 62
42 68
12 98
7
95 13
97 25
93 37
79 27
75 19
49 47
67 17
4
8 52
6 80
26 42 
2 72
9
51 19
39 11
37 29
81 3
59 5
79 23
53 7
43 33
77 21
	 */
	public static void main(String[] args) {
		dp1();
	}
	
	public static void dp1(){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
			int []input = new int[101];
			int ladder = in.nextInt();
			for(int j=0;j<ladder;j++){
				int s = in.nextInt();
				int e = in.nextInt();
				input[s] = e;
			}
			int snakes = in.nextInt();
			for(int j=0;j<snakes;j++){
				int s = in.nextInt();
				int e = in.nextInt();
				input[s] = e;
			}
			//think of recursion
			int []output = new int[101];
			for(int x=2;x<=100;x++){
				for(int y=1;y<=6;y++){
					if(x-y>=0 && output[x-y] >= 0){
						int temp = output[x-y]+1;
						if(output[x] == 0 || output[x] > temp){
							output[x] = temp;
						}
					}
				}
				if(input[x] != 0){
					//snake vs ladder
					if(input[x] > x){
						if(output[input[x]] == 0 || output[input[x]] > output[x]){
							output[input[x]] = output[x];
						}
					}else{
						output[x] = -1;
					}
//					output[x] = 
				}
//				System.out.println(x+" "+output[98]);
			}
			
			System.out.println(output[100]);
		}
	}
}
