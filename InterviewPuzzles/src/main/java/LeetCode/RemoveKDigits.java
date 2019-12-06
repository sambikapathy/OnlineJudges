package LeetCode;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits2(String num, int k) {
        StringBuilder sb = new StringBuilder(num);

        for (int i = 0; i < sb.length() - 1 && k > 0; ) {
            char o = sb.charAt(i);
            char t = sb.charAt(i + 1);
            if (o > t) {
                sb.deleteCharAt(i);
                k--;
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }

        while (k > 0) {
            int max = 0;
            int index = -1;
            for (int i = 0; i < sb.length(); i++) {
                if (max < sb.charAt(i)) {
                    max = sb.charAt(i);
                    index = i;
                }
            }
            sb.deleteCharAt(index);
            k--;
        }

        while (true && sb.length() > 0) {
            if (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            } else {
                break;
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String removeKdigits(String num, int k) {
        if(k==num.length()){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("1432219",3));
    }
}
