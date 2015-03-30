package OnlineJudge.HackerRank;

import java.util.Scanner;

public class SherlockAndArray {
/*
 * 
2
3
1 2 3
4
1 2 3 3
 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int size = in.nextInt();
			int []array = new int[size];
			for(int j=0;j<size;j++){
				array[j] = in.nextInt();
			}
			
			int s = 0; 
			int e = size-1;
			int ls = array[s] , rs = array[e];
			s++ ; e--;
			boolean isDone = true;
			while(s < e){
				isDone = false;
				if(ls < rs){
					ls+= array[s];
					s++;
				}else if(ls > rs){
					rs+= array[e];
					e--;
				}
				
				if(ls == rs){
					if(e==s){
						isDone = true;
						break;
					}else{
						ls+= array[s];
						s++;
					}
					
				}
			}
			if(isDone && (ls == rs)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}
