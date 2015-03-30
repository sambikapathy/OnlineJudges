package OnlineJudge.HackerRank;

import java.util.Scanner;

public class PalindromeIndex {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			String input = in.next();
			int start=0 , end = input.length()-1;
			int index = -1;
			while(start < end){
				char s = input.charAt(start);
				char e = input.charAt(end);
				if(s==e){
					start++ ; end--;
				}else{
					if(s == input.charAt(end-1) && (end-2>=0 && start+1 < input.length() && input.charAt(start+1)==input.charAt(end-2))){
						index = end;
//						break;
					}else if(e == input.charAt(start+1) && (end -1 >=0 && start+2 < input.length() && input.charAt(end-1)==input.charAt(start+2))){
						index = start;
//						break;
					}
					break;
						
				}
			}
			System.out.println(index);
		}
	}
}
