package OnlineJudge.HackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class FindDigits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			String input = in.next();
			BigInteger val = new BigInteger(input);
			int []index = new int[10];
			for(int j=1;j<10;j++){
				if(val.mod(new BigInteger(j+"")).intValue()==0){
					index[j]=1;
				}
			}
			int count = 0;
			for(int k=0;k<input.length();k++){
				char c = input.charAt(k);
				if(c!='0'){
					if(index[c-'0']==1){
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
