package LeetCode;

import java.util.Stack;

public class ValidParanthesis {

	public boolean isValid(String s) {
        if(s.length()%2 != 0){
            return false;
        }
        
        Stack<String> stk = new Stack<String>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                stk.push(c+"");
            }else{
                System.out.println(c);
                switch(c){
                    case '}':
                        if(stk.pop()!="{"){
                            return false;
                        }
                        break;
                    case ']':
                        if(stk.pop()!="["){
                            return false;
                        }
                        break;
                    case ')':
                    	String s1 = stk.pop();
                        if(s1!="("){
                            return false;
                        }
                        break;
                        
                }
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		String str = "()[]{}";
		System.out.println(new ValidParanthesis().isValid(str));
	}
}
