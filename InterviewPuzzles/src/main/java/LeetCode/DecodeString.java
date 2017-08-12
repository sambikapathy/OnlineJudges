package LeetCode;

import java.util.Iterator;
import java.util.Stack;

/**
 * 
 * Given an encoded string, return it's decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * s = "3[a]2[bc]", return "aaabcbc" s = "3[a2[c]]", return "accaccacc" s =
 * "2[abc]3[cd]ef", return "abcabccdcdcdef"
 * 
 * 2[ab2[ab]] ->
 * 
 * 
 * 
 * 2 ab abab ababaabababab
 * 
 * sd2[f2[e]g]i sdfeegfeegi sdfeegfeegi
 * 
 */
public class DecodeString {

	public static void main(String[] args) {
		// String input = "sd2[f2[e]g]i";
		String input = "3[a]2[bc]";
		System.out.println(new DecodeString().decodeString(input));
	}

	public String decodeString(String input) {
		Stack<Integer> oper = new Stack<>();
		Stack<String> operand = new Stack<>();
		for (int i = 0; i < input.length(); i++) {

			char c = input.charAt(i);
			if (c == ']') {
				int times = oper.pop();
				StringBuilder sb = new StringBuilder();
				String data = operand.pop();
				for (int j = 0; j < times; j++) {
					sb.append(getValue(data));
				}
				if (operand.isEmpty()) {
					String array = sb.toString();
					operand.push(array);
				} else {
					operand.push(operand.pop() + sb.toString());
				}
			} else if (c >= '0' && c <= '9') {
				StringBuilder sb = new StringBuilder();
				while (Character.isDigit(input.charAt(i))) {
					sb.append(input.charAt(i));
					i++;
				}
				i--;
				oper.push(Integer.parseInt(sb.toString()));
			} else {
				if (c == '[')
					i++;
				StringBuilder sb = new StringBuilder();
				while (i < input.length() && isLetter(input.charAt(i))) {
					sb.append(input.charAt(i));
					i++;
				}
				i--;
				// if (operand.isEmpty()) {
				String array = sb.toString();
				if (c == '[' || operand.isEmpty()) {
					operand.push(array);
				} else {
					operand.push(operand.pop() + array);
				}
				// } else {
				// operand.peek()[1] = sb.toString();
				// }
			}
		}

		Iterator<String> iterator = operand.iterator();
		StringBuilder sb = new StringBuilder();
		while (iterator.hasNext()) {
			String value = iterator.next();
			sb.append((value));
		}
		return (sb.toString());
	}

	private static String getValue(String string) {
		return string == null ? "" : string;
	}

	private static boolean isLetter(char charAt) {
		return (charAt >= 'a' && charAt <= 'z');
	}
}
