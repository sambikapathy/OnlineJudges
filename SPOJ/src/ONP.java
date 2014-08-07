import java.util.Scanner;
import java.util.Stack;


public class ONP {

	//
	public static void main (String[] args) throws java.lang.Exception
	  {
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();
		for(int i=0;i< total;i++){
			System.out.println(getRVN(in.next()));
		}
	  }
	
	private static String getRVN(String str){
		
		Stack<String> operand = new Stack<String>();
		Stack<String> result = new Stack<String>();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c >= 'a' && c<='z'){
				result.push(c+"");
			}else if(c=='('){
				result.push("(");
			}else if(c==')'){
				String one = result.pop();
				String two = result.pop();
				String op = operand.pop();
				result.pop();
				result.push(two+one+op);
			}else if(isOperator(c)){
				operand.push(c+"");
			}
		}
		return result.pop();
	}

	private static boolean isOperator(char c) {
		if(c=='+' || c=='-' ||c=='*' ||c=='/' ||c=='^'){
			return true;
		}
		return false;
	}
	
}
