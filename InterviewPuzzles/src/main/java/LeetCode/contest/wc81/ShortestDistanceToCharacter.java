package LeetCode.contest.wc81;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ShortestDistanceToCharacter {
    /**
     * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
     * <p>
     * Example 1:
     * <p>
     * Input: S = "loveleetcode", C = 'e'
     * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
     * <p>
     * <p>
     * <p>
     * Note:
     * <p>
     * S string length is in [1, 10000].
     * C is a single character, and guaranteed to be in string S.
     * All letters in S and C are lowercase.
     */

    public int[] shortestToChar(String S, char C) {

        char[] chars = S.toCharArray();

        int[] result = new int[chars.length];

        int lastC = Integer.MIN_VALUE / 2;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == C) {
                result[i] = 0;
                lastC = i;
            } else {
                result[i] = i - lastC;
            }
        }
        lastC = Integer.MAX_VALUE / 2;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != C) {
                result[i] = Math.min(result[i], lastC - i);
            } else {
                lastC = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new ShortestDistanceToCharacter().shortestToChar("loveleetcode", 'e');
        Arrays.stream(ints).forEach(i -> System.out.print(i + ","));
    }
}
