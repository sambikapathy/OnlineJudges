package OnlineJudge.HackerRank;

import java.util.Scanner;

public class Anagrams {
/*
 5
aaabbb
ab
abc
mnop
xyyx
 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			String input = in.next();
			if(input.length() %2 == 1){
				//FIXME revisit this
				System.out.println(-1);
			}else{
				char [] aa = input.substring(0, input.length()/2).toCharArray();
//				Arrays.sort(aa);
				
				char []bb = input.substring((input.length()/2),input.length()).toCharArray();
//				Arrays.sort(bb);
				
//				String a = new String(aa);
//				String b = new String(bb);
//				System.out.println(a + " " + b);
				int []count = new int[26];
				for(int j=0;j<aa.length;j++){
					count[aa[j]-'a']++;
				}
				for(int j=0;j<bb.length;j++){
					count[bb[j]-'a']--;
				}
				
				int total = 0;
				for(int c : count){
					if(c>0)
					total+=c;
				}
				System.out.println(total);
			}
		}
	}
}
