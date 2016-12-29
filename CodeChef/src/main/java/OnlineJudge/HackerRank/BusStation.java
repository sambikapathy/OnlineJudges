package OnlineJudge.HackerRank;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BusStation {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] input = new int[t];
		int sum = 0;
		int max = 0;
		for (int i = 0; i < t; i++) {
			int temp = in.nextInt();
			input[i] = temp;
			sum += temp;
			if (temp > max) {
				max = temp;
			}
		}

		Set<Integer> result = new TreeSet<>();
		for (int i = max; i <= sum; i++) {
			int k = i;
			boolean done = true;
			for(int j=0;j<t;j++){
				k-=input[j];
				if(k< 0){
					done = false;
					break;
				}else if(k==0){
					k=i;
				}
			}
			if(done && (k==0 || k==i)){
				result.add(i);
			}
		}
		result.stream().forEach((i)->System.out.print(i+" "));

	}
}
