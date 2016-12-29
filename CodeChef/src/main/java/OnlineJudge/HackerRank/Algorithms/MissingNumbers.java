package OnlineJudge.HackerRank.Algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<n;i++){
			int t = in.nextInt();
			if(map.containsKey(t)){
				map.put(t, map.get(t)+1);
			}else{
				map.put(t, 1);
			}
		}
		int m = in.nextInt();
		Set<Integer> missing = new TreeSet<>();
		for(int i=0;i<m;i++){
			int t = in.nextInt();
			if(map.containsKey(t)) {
				int total = map.get(t)-1;
				if(total == 0){
					map.remove(t);
				}else{
					map.put(t, total);
				}
			}else{
				missing.add(t);
			}
		}
		for(int i: missing){
			System.out.print(i+" ");
		}
		
	}
}
