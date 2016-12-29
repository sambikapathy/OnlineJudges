package OnlineJudge.HackerRank.Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountLuck {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++) {
			int n = in.nextInt();
			int m = in.nextInt();
			char [][] input = new char[n][m];
			int r=0, c=0;
			for(int j=0;j<n;j++){
				String line = in.next();
				for(int k=0;k<m;k++){
					input[j][k] =line.charAt(k);
					if(input[j][k]=='M'){
						r = j;
						c = k;
						input[j][k] = 'X';
					}
				}
			}
			int k = in.nextInt();
			
			if(findPathWithGuess(input , r , c, 0,k)){
				System.out.println("Impressed");
			}else{
				System.out.println("Oops!");
			}
		}
	}

	private static boolean findPathWithGuess(char[][] input,int r, int c,  int i, int k) {
		if(i > k){
			return false;
		}
		if(input[r][c] == '*'){
			return k == i;
		}
		List<Pair> paths = new ArrayList<>();
		if(r-1>=0){
			if(input[r-1][c]!='X'){
				paths.add(new Pair(r-1,c));
			}
		}
		if(c-1>=0){
			if(input[r][c-1]!='X'){
				paths.add(new Pair(r,c-1));
			}
		}
		if(r+1<input.length){
			if(input[r+1][c]!='X'){
				paths.add(new Pair(r+1,c));
			}
		}
		if(c+1 < input[0].length){
			if(input[r][c+1]!='X'){
				paths.add(new Pair(r,c+1));
			}
		}
		
		int inc = 0;
		if(paths.size()>1){
			inc=1;
		}
		for(Pair pair : paths){
			char[][]temp = makeNew(input);
			temp[r][c] = 'X';
			if(findPathWithGuess(temp, pair.first, pair.second, inc+i, k)){
				return true;
			}
		}
		return false;
		
	}
	
	
	private static char[][] makeNew(char[][] input) {
		int r = input.length;
		int c = input[0].length;
		char[][]temp = new char[r][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				temp[i][j] = input[i][j];
			}
		}
		return temp;
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
