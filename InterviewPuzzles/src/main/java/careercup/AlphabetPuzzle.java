package careercup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlphabetPuzzle {
	static boolean[] count = new boolean[26];
	static Set<Character> valueMap = new HashSet<>();
	static List<Character> uniqueChar = new ArrayList<>();

	static void populateFrequency(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (!valueMap.contains(input.charAt(i))) {
				valueMap.add(input.charAt(i));
			}
		}
	}

	/*
	 * 0,0,0 0,0,1 0,0,2 0,0,9 0,1,0
	 */
	private static void findValues(String[] input, String result) {
		Arrays.stream(input).forEach(str -> populateFrequency(str));
		uniqueChar.addAll(valueMap);
		int count = valueMap.size();
		for (long i = (int) Math.pow(10, count); i < Math.pow(10, count) - 1; i++) {
			String val = Long.toString(i);
			if (val.contains("0")) {
				continue;
			}
			Map<Character, Integer> map = new HashMap<>();
			for (int j = 0; j < val.length(); j++) {
				map.put(uniqueChar.get(j), Integer.parseInt(val.charAt(j) + ""));
			}

			int total = 0;
			for (int k = 0; k < input.length; k++) {
				total += Integer.parseInt(apply(input[k], map));
			}
			if (equals(total + "", result, map)) {
				System.out.println(map);
				System.out.println(i);
				break;
			}
		}

	}

	private static String apply(String input, Map<Character, Integer> valueMap) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			Integer value = valueMap.get(input.charAt(i));
			sb.append(value != null ? value : 0);
		}
		return sb.toString();
	}

	private static boolean equals(String value, String result, Map<Character, Integer> map) {
		if (value.length() != result.length()) {
			return false;
		}
		Map<Character, Integer> tempMap = new HashMap<>(map);
		for (int i = 0; i < value.length(); i++) {
			if (tempMap.containsKey(result.charAt(i))) {
				if (tempMap.get(result.charAt(i)) != Integer.parseInt(value.charAt(i) + "")) {
					return false;
				}
			} else {
				tempMap.put(result.charAt(i), Integer.parseInt(value.charAt(i) + ""));
			}
		}
		return true;
	}

	public static void main(String[] args) {

		String[] input = { "NORTH", "EAST", "SOUTH", "WEST" };
		String result = "EARTH";

		long stime = System.currentTimeMillis();
		findValues(input, result);
		System.out.println(System.currentTimeMillis() - stime);
	}

}
