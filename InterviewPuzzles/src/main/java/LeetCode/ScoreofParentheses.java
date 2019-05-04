package LeetCode;

import java.util.Stack;

public class ScoreofParentheses {
    public int scoreOfParentheses(String str) {
        Stack<String> stack = new Stack<>();
        char []ch = str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='('){
                stack.push("(");
            }else {
                int temp = 0;
                while(!stack.isEmpty()){
                    String s = stack.pop();
                    if(s.equals("(")){
                        if(temp == 0){
                            stack.push("1");
                        }else{
                            stack.push(temp*2+"");
                        }
                        break;
                    }else{
                        temp += Integer.parseInt(s);
                    }
                }
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result+= Integer.parseInt(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ScoreofParentheses().scoreOfParentheses("(()(()))"));
    }

}
