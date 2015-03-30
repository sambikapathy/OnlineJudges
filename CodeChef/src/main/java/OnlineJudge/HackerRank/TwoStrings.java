package OnlineJudge.HackerRank;

import java.util.Scanner;

public class TwoStrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			String a = in.next();
			String b = in.next();
			boolean isPresent = false;
			int []index = new int[26];
			for(int j=0;j<a.length();j++){
				char c = a.charAt(j);
				index[c-'a']++;
			}
			
			for(int j=0;j<b.length();j++){
				char c = b.charAt(j);
				if(index[c-'a']>0){
					isPresent = true;
					break;
				}
			}
			
			if(isPresent){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}
