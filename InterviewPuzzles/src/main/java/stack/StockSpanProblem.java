package stack;

public class StockSpanProblem {
	public static void printNGE(int[] input) {
		if (input == null || input.length == 0) {
			return;
		}
		LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
		int []result = new int[input.length];
		
		stack.push1(0);
		result[0] = 1;
		
		for(int i=1;i<input.length;i++){
			if(input[i] <= input[stack.peek1()]){
				result[i] = 1;
				
			}else{
				int count = 0;
				while(!stack.isEmpty() && input[i] > input[stack.peek1()]){
					count+=result[stack.pop1()];
				}
				result[i] = count+1;
			}
			stack.push1(i);
		
		}
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}

	public static void main(String[] args) {
		int[] input = {10, 4, 5, 90, 120, 80};
		printNGE(input);
	}
}
