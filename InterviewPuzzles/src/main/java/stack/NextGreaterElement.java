package stack;

public class NextGreaterElement {

	public static void printNGE(int[] input) {
		if (input == null || input.length == 0) {
			return;
		}
		LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
		stack.push1(input[input.length-1]);
		System.out.println(input[input.length-1] + " "+-1);
		for(int i=input.length-2;i>=0;i--){
			
			if(input[i] > stack.peek1()){
				while(!stack.isEmpty() && input[i] > stack.peek1()){
					stack.pop();
				}
				if(stack.isEmpty()){
					
					System.out.println(input[i]+" "+-1);
				}else{
					System.out.println(input[i]+""+stack.peek1());
				}
				stack.push1(input[i]);
			}else{
				System.out.println(input[i]+" "+stack.peek1());
				stack.push1(input[i]);
			}
		}
//		for(int i=0;i<input.length;i++){
//			System.out.println(input[i]+" "+stack.pop1());
//		}
	}

	public static void main(String[] args) {
		int[] input = { 13,7,6,12 };
		printNGE(input);
	}
}
