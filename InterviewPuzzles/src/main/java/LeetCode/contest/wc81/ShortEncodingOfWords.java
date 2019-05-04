package LeetCode.contest.wc81;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ShortEncodingOfWords {
    /**
     * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.
     * <p>
     * For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].
     * <p>
     * Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.
     * <p>
     * What is the length of the shortest reference string S possible that encodes the given words?
     * <p>
     * Example:
     * <p>
     * Input: words = ["time", "me", "bell"]
     * Output: 10
     * Explanation: S = "time#bell#" and indexes = [0, 2, 5].
     * <p>
     * Note:
     * <p>
     * 1 <= words.length <= 2000.
     * 1 <= words[i].length <= 7.
     * Each word has only lowercase letters.
     */
    public int minimumLengthEncoding_old(String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            boolean done = false;
            for (int i = 0; i < res.size(); i++) {
                String o1 = res.get(i);
                String o2 = word;
                if (o1.length() > o2.length()) {
                    if (o1.endsWith(o2)) {
                        done = true;
                        break;
                    }
                } else {
                    if (o2.endsWith(o1)) {
                        res.remove(i);
                        res.add(o2);
                        done = true;
                    }
                }
            }
            if (!done) {
                res.add(word);
            }
        }

        int result = 0;
        for (String word : res) {
            result += word.length() + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] input = {"me", "time"};
        System.out.println(new ShortEncodingOfWords().minimumLengthEncoding(input));
        System.out.println(new ShortEncodingOfWords().minimumLengthEncoding_old(input));
    }


    public int minimumLengthEncoding(String[] input) {

        Trie trie = new Trie();
        for (String str : input) {
            Trie.add(trie, str);
        }
        trie.count(trie, 1);
        int temp = Trie.total;
        Trie.total = 0;
        return temp;
    }

    static class Trie {

        Trie[] children = new Trie[26];
        boolean isChild = true;
        static int total = 0;

        static void add(Trie root, String word) {
            char[] input = word.toCharArray();
            for (int i = input.length - 1; i >= 0; i--) {
                char ch = input[i];
                if (root.children[ch - 'a'] == null) {
                    root.children[ch - 'a'] = new Trie();
                    root.isChild = false;
                }
                root = root.children[ch - 'a'];
            }
        }

        private void count(Trie root, int level) {
            if (root.isChild) {
                total+=level;
                return;
            }

            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    count(root.children[i], level + 1);
                }
            }
        }
    }

    //stime, htime
}
