package hackerrank;

import java.util.Arrays;

public class SherlockAnagrams {

    static int sherlockAndAnagrams(String s) {
        int total = 0;
        for (int len = 1; len < s.length(); len++) {
            for (int i = 0; i < s.length() - len; i++) {
                String temp1 = s.substring(i, i + len);
                char[] chars1 = temp1.toCharArray();
                Arrays.sort(chars1);
                temp1 = new String(chars1);
                for (int j = i + 1; j < s.length() - len + 1; j++) {
                    String temp = s.substring(j, j + len);
                    char[] chars = temp.toCharArray();
                    Arrays.sort(chars);
                    temp = new String(chars);
                    if (temp.equals(temp1)) {
                        total++;
                    }
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        String input = "kkkk";

        System.out.println(sherlockAndAnagrams(input));
    }
}
