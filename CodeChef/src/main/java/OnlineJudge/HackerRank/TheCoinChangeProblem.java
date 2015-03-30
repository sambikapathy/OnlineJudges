package OnlineJudge.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheCoinChangeProblem {
//1, 2, 3
//	4
	static BufferedReader in = new BufferedReader(new InputStreamReader(
	         System.in));
	static int []array = null;
	static int target = 0;
	static int count = 0;
	public static void main(String[] args) throws Exception{
		String []input = in.readLine().split(",");
		target = Integer.parseInt(in.readLine().trim());
		array = new int[input.length];
		for(int i=0;i<array.length;i++){
			array[i] = Integer.parseInt(input[i].trim());
		}
		Arrays.sort(array);
		calculateCoins(0, 0);
		System.out.println(count);
	}
	
	public static boolean calculateCoins(int value, int index) {
		if (index < array.length) {
			for (int i = index; i < array.length; i++) {
				if (value + array[i] == target) {
					count++;
					return false;
				} else if (value + array[i] > target) {
					return false;
				} else {
					calculateCoins(value + array[i], i);
				}
			}
		}
		return false;
	}
}
