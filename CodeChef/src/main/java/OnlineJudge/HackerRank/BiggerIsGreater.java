package OnlineJudge.HackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class BiggerIsGreater {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			String input = in.next();
			StringBuilder sb = new StringBuilder(input);
			boolean isDone = false;
			int jump = 1;
			int end = input.length()-1;
			boolean isSuccess = false;
			while(!isDone){
				if(end-1<0){
					jump++;
					if(jump==input.length()){
						break;
					}
					continue;
				}
				char r = input.charAt(end);
				char l = input.charAt(end-jump);
				if(l < r){
					char min = input.charAt(end-jump+1);
					int index = 0;
					for(int k = end-jump+1;k<input.length();k++){
						if(input.charAt(k) < min && input.charAt(k)>l){
							min = input.charAt(k);
							index = k;
						}
					}
					sb.setCharAt(end-1, min);
					sb.setCharAt(index,l);
					isSuccess = true;
					System.out.println(sb.substring(0, end-1)+sortString(sb.substring(end, sb.length())));
					break;
				}else{
					end=end-1;
				}
			}
			if(!isSuccess){
				System.out.println("no answer");
			}
		}
	}
	
	private static String sortString(String input){
		char c[] =input.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
