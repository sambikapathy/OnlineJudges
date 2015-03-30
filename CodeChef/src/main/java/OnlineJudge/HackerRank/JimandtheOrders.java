package OnlineJudge.HackerRank;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class JimandtheOrders {

	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TreeMap<Integer, TreeSet<Integer>> result = new TreeMap<Integer, TreeSet<Integer>>();
		for (int i = 0; i < n; i++) {
			int total = in.nextInt()+ in.nextInt();
			if(result.containsKey(total)){
				result.get(total).add(i+1);
			}else{
				TreeSet<Integer> set = new TreeSet<Integer>();
				set.add(i+1);
				result.put(total, set);
			}
		}
		for(Map.Entry<Integer, TreeSet<Integer>> entry : result.entrySet()){
			TreeSet<Integer> set = entry.getValue();
			for(int value : set){
				System.out.print(value+" ");
			}
		}
	}
}
