package interviewbit;

import java.util.Stack;

public class RedundantBraces {

	public int braces(String A) {
		Stack<Character> oper = new Stack<>();
		Stack<String> opnd = new Stack<>();
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			switch (c) {
			case '(':
				oper.push(c);
				break;
			case ')':
				boolean isDone = false;
				while (oper.peek() != '(') {
					isDone = true;
					char t = oper.pop();
					opnd.push(opnd.pop() + "" + opnd.pop());
				}
				oper.pop();
				if (!isDone) {
					return 1;
				}
				break;
			case '+':
			case '-':
			case '/':
			case '*':
				oper.push(c);
				break;
			default:
				opnd.push(c + "");
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		String input = "((a+b))";
		System.out.println(new RedundantBraces().braces(input));
	}
}
