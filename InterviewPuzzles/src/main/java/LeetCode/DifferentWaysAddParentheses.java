package LeetCode;

import java.util.List;

/*
 Input: "2*3-4*5"
 (2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10

 */
//ND 
public class DifferentWaysAddParentheses {
	// private void printrec(String prefix, String input, int max, int sofar) {
	// if (input.length() == 0) {
	// System.out.println(prefix);
	// return;
	// }
	//
	// char c = input.charAt(0);
	// if (c == '*' || c == '-' || c == '+') {
	// prefix += c;
	// printrec(prefix, input.substring(1), max, sofar);
	// return;
	// }
	//
	// int no = Integer.parseInt(c + "");
	// printrec(prefix + "(" + no, input.substring(1), max, sofar + 1);
	// printrec(prefix + "(" + no, input.substring(1), max, sofar + 1);
	// }

	public List<Integer> diffWaysToCompute(String input) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '*' || c == '-' || c == '+') {
				count++;
			}
		}
		// printrec("", input, count, 0);
		return null;
	}

	public static void main(String[] args) {
		String input = "2*3-4*5";
		System.out.println(new DifferentWaysAddParentheses().diffWaysToCompute(input));
	}

}
