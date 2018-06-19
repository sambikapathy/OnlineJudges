package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class WildcardMatching {

	static int count = 0;

	static Map<String, Boolean> result = new HashMap<>();

	public static boolean isMatchRec(String input, String regex) {
		count++;
		String key = input + ":" + regex;
		if (result.containsKey(key)) {
			return result.get(key);
		}
		if (input.length() == 0 && regex.length() == 0) {
			result.put(key, true);
			return true;
		}
		if (input.length() == 0 || regex.length() == 0) {
			result.put(key, false);
			return false;
		}
		if (input.charAt(0) == regex.charAt(0) || regex.charAt(0) == '?') {
			key = input.substring(1) + ":" + regex.substring(1);
			boolean matchRec = isMatchRec(input.substring(1), regex.substring(1));
			result.put(key, matchRec);
			return matchRec;
		} else if (regex.charAt(0) == '*') {
			for (int i = 0; i < input.length(); i++) {
				if (isMatchRec(input, regex.substring(1))) {
					result.put(input + ":" + regex.substring(1), true);
					return true;
				} else if (isMatchRec(input.substring(1), regex.substring(1))) {
					result.put(input.substring(1) + ":" + regex.substring(1), true);
					return true;
				} else if (isMatchRec(input.substring(1), regex)) {
					result.put(input.substring(1) + ":" + regex, true);
					return true;
				}
			}
		}
		result.put(input + ":" + regex, true);
		return false;
	}

	public static void main(String[] args) {
		String input = "aabacaaabacaaabacaa";
		String regex = "*ac";
		System.out.println(isMatchRec(input, regex));
		System.out.println(count);
		System.out.println(result.size());
	}

}
