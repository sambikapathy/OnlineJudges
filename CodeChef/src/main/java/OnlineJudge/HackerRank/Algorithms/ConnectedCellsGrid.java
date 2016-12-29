package OnlineJudge.HackerRank.Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectedCellsGrid {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int [][] input = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				input[i][j] = in.nextInt();
			}
		}
	
		int max = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(input[i][j]==1){
					AtomicInteger temp = new AtomicInteger(0);
					dfs(input, i, j, temp);
					if(temp.intValue() > max){
						max = temp.intValue();
					}
				}
			}
		}
		
		System.out.println(max);
		
	}
	
	public static void dfs(int [][]input, int r , int c, AtomicInteger count){
		if(input[r][c] == 0){
			return;
		}
		
		if(input[r][c]==1){
			input[r][c]=0;
			count.incrementAndGet();
		}
		
		
		
		List<Pair> list = new ArrayList<>();
		if(r-1 >=0){
			if(input[r-1][c]==1){
				list.add(new Pair(r-1,c));
			}
			
			if(c-1 >=0){
				if(input[r-1][c-1]==1){
					list.add(new Pair(r-1,c-1));
				}
			}
			
			if(c+1 < input[0].length){
				if(input[r-1][c+1]==1){
					list.add(new Pair(r-1,c+1));
				}
			}
		}
		
		if(c-1 >=0){
			if(input[r][c-1]==1){
				list.add(new Pair(r,c-1));
			}
		}
		
		if(c+1 < input[0].length){
			if(input[r][c+1]==1){
				list.add(new Pair(r,c+1));
			}
		}
		
		if(r+1 < input.length){
			if(input[r+1][c]==1){
				list.add(new Pair(r+1,c));
			}
			
			if(c-1 >=0){
				if(input[r+1][c-1]==1){
					list.add(new Pair(r+1,c-1));
				}
			}
			
			if(c+1 < input[0].length){
				if(input[r+1][c+1]==1){
					list.add(new Pair(r+1,c+1));
				}
			}
		}
		
		for(Pair pair : list){
			dfs(input, pair.first, pair.second, count);
		}
		
	}
	
	static class Pair {
		public int first;
		public int second;

		public Pair(int f, int s) {
			first = f;
			second = s;
		}
	}
}
