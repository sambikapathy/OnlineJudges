package div2Level500;

import java.util.HashSet;
import java.util.Set;

public class TheLuckyString {

	//SRM 428
	public static void main(String[] args) {
		new TheLuckyString().recursive(0, "", "aaaabbcc");
		
		for(String str : resultSet){
			System.out.println(str);
		}
	}

	static Set<String> resultSet = new HashSet<String>();
	public int count(String s) {
		recursive(0, "", s);
		return resultSet.size();
	}

	private void recursive(int index, String temp, String s) {

		if (s.length() == 0) {
			resultSet.add(temp);
		}

		for (int i = 0; i < s.length(); i++) {
			if (temp.length() >= 1) {
				if (temp.charAt(temp.length() - 1) == s.charAt(i)) {
					 continue;
				}
			}
			recursive(i, temp + s.charAt(i),
					s.substring(0, i) + s.substring(i + 1, s.length()));
		}

	}
}