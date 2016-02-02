package stack;

public class ReverseStack {

	public static void reverse(LinkedListStack<Integer> stack){
		if(stack.isEmpty()){
			return;
		}
		int c = stack.pop1();
		reverse(stack);
		insertAtBottom(stack , c);
	}
	
	private static void insertAtBottom(LinkedListStack<Integer> stack, int c) {
		if(stack.isEmpty()){
			stack.push1(c);
			return;
		}
		int t = stack.pop1();
		insertAtBottom(stack , c);
		stack.push1(t);
	}

	public static void main(String[] args) {
		LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
		for (int i = 1; i < 5; i++) {
			stack.push1(i);
		}
		reverse(stack);
		while(!stack.isEmpty()){
			System.out.println(stack.pop1());
		}
	}
}
