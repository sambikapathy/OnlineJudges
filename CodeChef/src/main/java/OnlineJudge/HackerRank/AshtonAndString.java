package OnlineJudge.HackerRank;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AshtonAndString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String input = in.next();
			int k = in.nextInt() - 1;
			Set<String> treeSet = new TreeSet<String>();
			for (int a = 0; a < 26; a++) {
				int index = input.indexOf('a' + a);
				while (index >= 0) {
					// for (int j = index; j < input.length(); j++) {
					for (int x = index + 1; x <= input.length(); x++) {
						treeSet.add(input.substring(index, x));
						System.out.println(input.substring(index, x));
					}
					// }
					index = input.indexOf('a' + a, index + 1);
				}
			}
			int total = 0;
			for (String str : treeSet) {
				 System.out.print(str+",");
//				if (total + str.length() >= k) {
//					System.out.println(str.charAt(k - total));
//					break;
//				} else {
//					total += str.length();
//
//				}
			}
		}
	}
}

