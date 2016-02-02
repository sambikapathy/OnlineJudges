package LeetCode;

public class Solution {
	
	public static void main(String[] args) {
		new Solution().reverseWords("   a   b ");
	}
    public String reverseWords(String s) {
        s = s.trim();
        s =  reverse(s.trim());
        
        StringBuilder sb = new StringBuilder(s.length());
        StringBuilder result = new StringBuilder(s.length());
        for(int i=0;i<s.length();){
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
                i++;
            }else{
                while(s.charAt(i)==' ')i++;
                result.append(reverse(sb.toString())+" ");
                sb = new StringBuilder();
            }
        }
        if(sb.length() > 0){
            result.append(reverse(sb.toString()));
        }
        return result.toString();
    }
    
    private String reverse(String s){
        int start = 0 , end = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while(start < end){
            sb.setCharAt(start , s.charAt(end));
            sb.setCharAt(end , s.charAt(start));
            start++;
            end--;
        }
        return sb.toString();
    }
}