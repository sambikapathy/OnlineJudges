package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        List<List<Integer>> tracker = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            tracker.add(new ArrayList<>());
        }
        char[] inp = t.toCharArray();
        for (int i = 0; i < inp.length; i++) {
            int index = inp[i] - 'a';
            List<Integer> integers = tracker.get(index);
            integers.add(i);
        }

        char[] result = s.toCharArray();
        int prev = -1;
        for (int i = 0; i < result.length; i++) {
            int index = result[i] - 'a';

            int next = findNextIndex(tracker.get(index), prev);
            if (next == -1) {
                return false;
            }
            prev = next;
        }
        return true;
    }

    private int findNextIndex(List<Integer> integers, int prev) {
        for (int i : integers) {
            if (i > prev) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        IsSubsequence seq = new IsSubsequence();
        System.out.println(seq.isSubsequence("twn","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxtxxxxxxxxxxxxxxxxxxxxwxxxxxxxxxxxxxxxxxxxxxxxxxn"));
    }
}