package stack;

public class BalancedParentheses {

	//PREP can this be done 
	public static boolean evaluateParanthesis(String input){
		LinkedListStack<Character> stack = new LinkedListStack<Character>();
		for(int i=0;i<input.length();i++){
			char c = input.charAt(i);
			if(c=='('||c=='{'||c=='['){
				stack.push1(c);
			}else if(c==')'||c=='}'||c==']'){
				if(stack.isEmpty()){
					throw new RuntimeException("Not matching");
				}
				char t = stack.peek1();
				if(c==')' && t=='(' || c=='}' && t=='{' || c==']' && t=='['){
					stack.pop1();
				}else{
					throw new RuntimeException("Not matching");
				}
			}else{
				throw new RuntimeException("Invalid Character");
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String input = "(([)])";
		System.out.println(evaluateParanthesis(input));
	}
}
