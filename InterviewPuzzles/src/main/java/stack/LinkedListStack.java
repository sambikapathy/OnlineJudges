package stack;

import LinkedList.Node;
//PREP support findMiddle and DeleteMiddle in O(1)
//http://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/

public class LinkedListStack<T> {

	private Node<T> top;

	public void push(Node<T> first) {
		first.next = top;
		top = first;
	}

	public Node<T> pop() {
		Node<T> temp = null;
		if (top != null) {
			temp = top;
			top = top.next;
		}
		return temp;
	}

	public Node<T> peek() {
		return top;
	}

	public void push1(T c) {
		Node first = new Node(c);
		first.next = top;
		top = first;
	}

	public T pop1() {
		Node<T> temp = null;
		if (top != null) {
			temp = top;
			top = top.next;
		}
		return temp.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public T peek1() {
		return top.data;
	}

	public static LinkedListStack<Character> createStack(String input) {
		LinkedListStack<Character> stack = new LinkedListStack<Character>();
		for (int i = 0; i < input.length(); i++) {
			Node<Character> node = new Node(input.charAt(i));
			stack.push(node);
		}
		return stack;
	}

	// "a+b*(c^d-e)^(f+g*h)-i"
	// abcd^e-fgh*+^*+i-
	// abcd^e-fgh*+^*+i-
	// a b c d ^ e - f g h * + ^ * + i -
	public String infixToPostfix(String input) {
		LinkedListStack<Character> stack = new LinkedListStack<Character>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			Node node = new Node(c);
			int cp = getPriority(c);
			if ((c >= 'a' && c <= 'z')) {
				System.out.print(c);
			} else {
				if (c == ')') {
					char t;
					while ((t = stack.pop().data) != '(') {
						System.out.print(t);
					}
					System.out.print("");
				} else if (c == '(') {
					stack.push(node);
				} else if (stack.peek() != null
						&& cp <= getPriority(stack.peek().data)) {

					while (stack.peek() != null
							&& cp <= getPriority(stack.peek().data)) {
						System.out.print(stack.pop().data);
					}

					stack.push(node);
				} else {
					stack.push(node);
				}
			}
		}
		while (stack.peek() != null) {
			System.out.print(stack.pop().data);
		}
		return "";
	}

	public int getPriority(Character c) {
		switch (c) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;

	}

	public String reverseString(String input) {
		LinkedListStack<Character> stack = new LinkedListStack<Character>();
		for (int i = 0; i < input.length(); i++) {
			Node<Character> node = new Node(input.charAt(i));
			stack.push(node);
		}
		StringBuilder sb = new StringBuilder();
		while (stack.peek() != null) {
			sb.append(stack.pop().data);
		}
		return sb.toString();
	}

	public String reverseStringNoSpace(String input) {
		// StringBuilder sb = new StringBuilder(input);
		// int s = 0 , e = sb.length()-1;
		// while(s<e){
		// char t = sb.charAt(s);
		// sb.setCharAt(s,sb.charAt(e));
		// sb.setCharAt(e,t);
		// s++;
		// e--;
		// }
		// return sb.toString();

		char[] array = input.toCharArray();
		int s = 0, e = array.length - 1;
		while (s < e) {
			char t = array[s];
			array[s] = array[e];
			array[e] = t;
			s++;
			e--;
		}
		return new String(array);

	}

	public static void main(String[] args) {
		String input = "a+b*(c^d-e)^(f+g*h)-i";
		LinkedListStack<Character> stack = LinkedListStack.createStack(input);
		// stack.infixToPostfix(input);

		System.out.println(stack.reverseString("test"));
		System.out.println(stack.reverseStringNoSpace("test"));

	}

	// PREP pending problems
	// http://geeksquiz.com/stack-set-2-infix-to-postfix/
	// http://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/

}
