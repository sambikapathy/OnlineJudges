package LeetCode;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        String postfix = getPostFix(s);
        
        int result =0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<postfix.length();i++){
            char c = postfix.charAt(i);
            if(c>='0' && c<='9'){
                stack.push(0+(c-'0'));
            }else{
               stack.push(getValue(c,stack.pop(),stack.pop())); 
            }
        }
        return stack.pop();
    }
    
     private int getValue(char c, int two , int one){
        switch(c){
            case '*': return one*two;
            case '/': return one / two;
            case '+': return one + two;
            case '-': return one - two;
        }
        return 0;
    }
    
    public String getPostFix(String input){
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(c ==' '){
                continue;
            }
            
            if(c>='0' && c<='9'){
                sb.append(c);
            }else{
                while(!stack.empty()){
                    int current = getPriority(c);
                    int top = getPriority(stack.peek().charAt(0));
                    
                    if(current > top){
                        break;
                    }
                    
                    sb.append(stack.pop());
                }
                stack.push(c+"");
            }
        }
        
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    
    private int getPriority(char c){
        switch(c){
            case '*': 
            case '/': return 2;
            case '+': 
            case '-': return 1;
        }
        return 0;
    }
}