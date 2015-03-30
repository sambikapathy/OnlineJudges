package OnlineJudge.HackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ACMICPC {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int [][]array = new int[n][m];
		for(int i=0;i<n;i++){
			String input = in.next();
			for(int j=0;j<m;j++){
				array[i][j] = input.charAt(j)-'0';
			}
		}
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int max = 0 ;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				int count = 0;
				for(int k=0;k<m;k++){
					count+= (array[i][k]|array[j][k]);
				}
				if(!map.containsKey(count)){
					map.put(count, 0);
				}
				map.put(count, map.get(count)+1);
				if(count > max){
					max = count;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(map.get(max));
	}
}
