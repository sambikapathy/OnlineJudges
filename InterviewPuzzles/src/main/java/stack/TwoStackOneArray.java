package stack;

public class TwoStackOneArray {

	int[] array;
	int top1, top2;
	int capacity;

	public TwoStackOneArray(int capacity) {
		array = new int[capacity];
		top1 = -1;
		top2 = capacity;
		this.capacity = capacity;
	}

	public void push1(int data) {
		if(top2-top1 == 1){
			System.out.println("Stack is full");
			return;
		}
		array[++top1] = data;
	}

	public int pop1() {
		if(top1==-1){
			System.out.println("Stack is empty");
			return -1;
		}
		return array[top1--];
	}

	public int peek1() {
		return array[top1];
	}

	public void push2(int data) {
		if(top2-top1 == 1){
			System.out.println("Stack is full");
			return;
		}
		array[--top2] = data;
	}

	public int pop2() {
		if(top2==capacity){
			System.out.println("Stack is empty");
			return -1;
		}
		return array[top2++];
	}

	public int peek2() {
		return array[top2];
	}
	
	public static void main(String[] args) {
		TwoStackOneArray stack = new TwoStackOneArray(2);
		stack.push1(1);
		stack.push1(1);
		stack.pop1();
		stack.push2(1);
	}
}
