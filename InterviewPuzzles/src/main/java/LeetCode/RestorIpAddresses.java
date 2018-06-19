package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class RestorIpAddresses {

	public static List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		restoreIpAddresses("", "", s, result, 0);
		return new ArrayList<>(result);
	}

	static int total = 0;

	public static void restoreIpAddresses(String prefix, String curr, String s, List<String> result, int count) {
		total++;
		if (count > 2) {
			return;
		}
		if (s.length() == 0) {
			if (count == 2) {
				result.add(prefix + "." + curr);
			}
			return;
		}

		if (Integer.valueOf(curr + s.charAt(0) + "") < 256) {
			restoreIpAddresses(prefix, curr + s.charAt(0), s.substring(1), result, count);
			if (prefix.length() == 0) {
				prefix = curr;
			} else {
				prefix = prefix + "." + curr;
				count++;
			}
			restoreIpAddresses(prefix, "" + s.charAt(0), s.substring(1), result, count);
		} else {
			if (prefix.length() == 0) {
				prefix = curr;
			} else {
				prefix = prefix + "." + curr;
				count++;
			}
			restoreIpAddresses(prefix, "", s, result, count);
		}

	}

	public static void main(String[] args) {
		String input = "25525511135";
		restoreIpAddresses(input).stream().forEach(System.out::println);
		System.out.println(total);
	}
}
