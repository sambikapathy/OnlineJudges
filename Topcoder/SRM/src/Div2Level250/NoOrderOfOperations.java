package div2Level250;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 Problem Statement
     
 When evaluating a mathematical expression, there is the possibility of ambiguity. If you wanted to know the result of "3 + 5 * 7", you might first evaluate the (3+5) and get 56, or first evaluate the (5*7) and get 38. 
 This ambiguity can be resolved by using the order of operations: first do multiplication and division (from left to right), and then after all those are done, do addition and subtraction (again from left to right). 
 Here, the correct result would be the 38.
 While this is unambiguous, it certainly is somewhat annoying. You think it would be easier if people did all math from left to right, all the time, and want to make a simple expression evaluator to do so.
 The expression will be given to you as a String expr. It will consist of one digit numbers (0 through 9) alternating with operators (+, -, or *), with no spaces between them. Thus, expr would follow the format Digit Operator Digit Operator .... Digit. For example, the expression given above would be given as "3+5*7".
 Your method should return an int representing the value of the expression when evaluated from left to right.
 Definition
     
 Class:
 NoOrderOfOperations
 Method:
 evaluate
 Parameters:
 String
 Returns:
 int
 Method signature:
 int evaluate(String expr)
 (be sure your method is public)
     

 Constraints
 -
 expr will be between 1 and 17 characters in length, inclusive.
 -
 expr will contain an odd number of characters.
 -
 expr will follow the format Digit Operator Digit Operator ... Digit, where each Digit is a single character from '0' to '9', and each Operator is either +, -, or *.
 Examples
 0)

     
 "3+5*7"
 Returns: 56
 First we add 3 + 5 to get 8. Then, we multiply 8 by 7 to get 56.
 1)

     
 "4-8*9*1"
 Returns: -36
 Results can be negative.
 2)

     
 "0"
 Returns: 0

 3)

     
 "1*2*3*4*5*6*7*8*9"
 Returns: 362880


1 2 3 4 5 6
* + *
 This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 */
public class NoOrderOfOperations {
	 
	public int evaluate(String expr) {
		List<Integer> operands = new ArrayList<Integer>();
		List<String> operator = new ArrayList<String>();
		
		//int sum = 1;
		if(expr.length() <2){
			return expr.charAt(0)-'0';
		}
		for(int i=0;i<expr.length();i+=2){
			operands.add(expr.charAt(i)-'0');
		}
		for(int i=1;i<expr.length();i+=2){
			operator.add(expr.charAt(i)+"");
		}
		int opindex = 0;
		for(int i=0;i<operator.size();i++){
			int a = operands.get(opindex);
			int b = operands.get(opindex+1);
			char oper = operator.get(i).charAt(0);
			int sum = 0;
			if(oper == '+'){
				sum+= (a+b);
			}else if(oper == '-'){
				sum+= (a-b);
			}else if(oper == '*'){
				sum+= (a*b);				
			}else if(oper == '/'){
				sum+= (a/b);
			}
			operands.set(opindex+1, sum);
			opindex++;
			
		}
		
		return operands.get(opindex);
	}
	
	public static void main(String[] args) {
		NoOrderOfOperations op = new NoOrderOfOperations();
		System.out.println(op.evaluate("3+5*7"));
		System.out.println(op.evaluate("4-8*9*1"));
		System.out.println(op.evaluate("0"));
		System.out.println(op.evaluate("1*2*3*4*5*6*7*8*9"));
		
	}
}
