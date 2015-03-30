package OnlineJudge.HackerRank;

import java.util.Scanner;

public class MakeItAnagram {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		int []av = new int[26];
		int []bv = new int[26];
		for(int i=0;i<a.length();i++){
			av[a.charAt(i)-'a']++;
		}
		for(int i=0;i<b.length();i++){
			bv[b.charAt(i)-'a']++;
		}
		
		int count = 0;
		for(int i=0;i<26;i++){
			count+= Math.abs(av[i]-bv[i]);
		}
		System.out.println(count);
	}
}
