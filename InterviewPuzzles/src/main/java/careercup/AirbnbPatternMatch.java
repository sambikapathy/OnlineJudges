package careercup;

import java.util.HashMap;
import java.util.Stack;

public class AirbnbPatternMatch {
	/**
	 * "xyzxy" and "airbnbairbn" return true. "ccc" and "airairair" return true.
	 */

	private static boolean matches(String input, String regex) {
		return matches(input, regex, new HashMap<String, String>(), new Stack<Character>());
	}

	private static boolean matches(String input, String regex, HashMap<String, String> hashMap,
			Stack<Character> stack) {
		if (input.length() == 0 && regex.length() == 0) {
			System.out.println(hashMap);
			return true;
		}
		if (input.length() == 0 || regex.length() == 0) {
			return false;
		}

		if (hashMap.containsKey(String.valueOf(regex.charAt(0)))) {
			String value = hashMap.get(String.valueOf(regex.charAt(0)));
			for (int i = 0; i < value.length(); i++) {
				if (value.charAt(i) != input.charAt(i)) {
					return false;
				}
			}
			return matches(input.substring(value.length()), regex.substring(1), hashMap, stack);
		} else {
			for (int i = 1; i <= input.length(); i++) {
				String pref = input.substring(0, i);
				hashMap.put(String.valueOf(regex.charAt(0)), pref);
				stack.push(regex.charAt(0));
				if (matches(input.substring(i), regex.substring(1), hashMap, stack)) {
					return true;
				} else {
					hashMap.remove(String.valueOf(stack.pop()));
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String input = "airbnbairbnb";
		String regex = "xyzxyz";

		System.out.println(matches(input, regex));
	}
}
