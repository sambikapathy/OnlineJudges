package interviewbit;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string,
 * find the length of the longest substring without repeating characters.
 * <p>
 * Example:
 * <p>
 * The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * <p>
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {
        Map<String, Integer> index = new HashMap<>();
        char[] input = A.toCharArray();
        int start = -1;
        int max = 1;
        for (int i = 0; i < input.length; i++) {
            if (start == -1) {
                index.put(input[i] + "", i);
                start = 0;
            } else {
                if (index.containsKey(input[i] + "")) {
                    int pos = index.get(input[i] + "");
                    for (int j = start; j <= pos; j++) {
                        index.remove(input[j] + "");
                        if(input[j] == input[i]){
                            start = j+1;
                            break;
                        }
                    }
                    index.put(input[i] + "", i);
                } else {
                    index.put(input[i] + "", i);
                    if (i - start + 1 > max) {
                        max = i - start + 1;
                    }
                }
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring("bb"));
    }
}
