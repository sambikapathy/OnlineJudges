package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.
 * <p>
 * For a given query word, the spell checker handles two categories of spelling mistakes:
 * <p>
 * Capitalization: If the query matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the case in the wordlist.
 * Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
 * Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
 * Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
 * Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel individually, it matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the match in the wordlist.
 * Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
 * Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
 * Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)
 * <p>
 * In addition, the spell checker operates under the following precedence rules:
 * <p>
 * When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
 * When the query matches a word up to capitlization, you should return the first such match in the wordlist.
 * When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
 * If the query has no matches in the wordlist, you should return the empty string.
 * <p>
 * Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
 * Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= wordlist.length <= 5000
 * 1 <= queries.length <= 5000
 * 1 <= wordlist[i].length <= 7
 * 1 <= queries[i].length <= 7
 * All strings in wordlist and queries consist only of english letters.
 */
public class VowelSpellchecker {

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> matches = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        Map<String, String> vowel = new HashMap<>();
        for (String str : wordlist) {
            matches.add(str);
            map.putIfAbsent(str.toLowerCase(), str);
            vowel.putIfAbsent(str.toLowerCase().replaceAll("[aeiou]", "."), str);
        }

        String[] result = new String[queries.length];
        int index = 0;
        for (String str : queries) {
            if (matches.contains(str)) {
                result[index++] = str;
                continue;
            }

            String lc = map.get(str.toLowerCase());
            if ( lc != null) {
                result[index++] = lc;
                continue;
            }

            String vs = vowel.get(str.toLowerCase().replaceAll("[aeiou]", "."));
            if (vs != null) {
                result[index++] = vs;
            } else {
                result[index++] = "";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] wordlist = {"ae", "aa"};
        String[] queries = {"UU"};
        String[] spellchecker = new VowelSpellchecker().spellchecker(wordlist, queries);
        //["KiTe","","KiTe"]
        //[ kite, , kite]
        System.out.println(Arrays.toString(spellchecker));
    }
}
