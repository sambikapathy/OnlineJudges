package LeetCode;

public class BackspaceStringCompare {

    private boolean isChar(char ch){
        return ch >='a' && ch <='z';
    }

    private String getNextCharPos(String input, int start){
        if(start<0 || start >= input.length()){
            return input;
        }
        if(isChar(input.charAt(start))){
            return getNextCharPos(input, start+1);
        }
        int i = start;
        while(i>=0){
            if(isChar(input.charAt(i))){
                break;
            }
            if(i==0){
                return getNextCharPos(input.substring(1),0);
            }
            i--;
        }
        return getNextCharPos(input.substring(0,i)+input.substring(start+1),i);
    }
    public boolean backspaceCompare(String S, String T) {
        return getNextCharPos(S,0).equals(getNextCharPos(T,0));
    }
    public static void main(String[] args) {
        String A = "a##c";
        String B = "#a#c";

        System.out.println(new BackspaceStringCompare().backspaceCompare(A,B));
    }
}
