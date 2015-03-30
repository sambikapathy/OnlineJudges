package OnlineJudge.HackerRank;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BuildingAList {

	// 2
	// 2
	// ab
	// 3
	// xyz

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int k = in.nextInt();
			int total = (int) Math.pow(2, k);
			String input = in.next();
			Set<String> treeSet = new TreeSet<String>();
			for (int j = 0; j < total; j++) {
				int m = j;
				int index = input.length() - 1;
				StringBuilder sb = new StringBuilder();
				while (m > 0) {
					int val = (m & 1);
					if(val > 0)
					sb.append(input.charAt(index));
					// System.out.print("index "+index+" - "+(m&1)+" " );
					m = m >> 1;
					index--;
				}
				if(sb.length() > 0)
				treeSet.add(sb.reverse().toString());
			}
			
			for(String str:treeSet){
				System.out.println(str);
			}
		}
	}
}
