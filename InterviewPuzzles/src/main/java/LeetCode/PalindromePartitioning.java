package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition("", s, new ArrayList<>(), result);
        return result;
    }

    public void partition(String prefix, String rest, List<String> temp, List<List<String>> result) {

    }

    private boolean isPalin(String input) {
        if (input.length() == 0) {
            return false;
        }
        int s = 0, e = input.length() - 1;
        char[] test = input.toCharArray();
        while (s < e) {
            if (test[s] != test[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> result = new PalindromePartitioning().partition("cbbbcc");
        System.out.println(result);
    }
}
