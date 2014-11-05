package OnlineJudge.HackerRank;

import java.util.Scanner;

public class GameofThrones {

	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		String inputString = myScan.nextLine();

		int[] array = new int[26];
		for (int i = 0; i < inputString.length(); i++) {
			array[inputString.charAt(i) - 'a']++;
		}
		boolean isNo = false;
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (array[i] % 2 != 0) {
				if (count == 0) {
					count++;
				} else {
					isNo = true;
					break;
				}
			}
		}
		if (isNo) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}

		myScan.close();
    }
	
}
