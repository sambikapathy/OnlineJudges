package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * <p>
 * Example 3:
 * <p>
 * Input:
 * "Aabb"
 * <p>
 * Output:
 * "bbAa"
 * <p>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */


public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> cache = new HashMap<>();
        for (char c : s.toCharArray()) {
            cache.put(c, cache.getOrDefault(c,0)+1);
        }

        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>((o1, o2) -> {
            return o2.count - o1.count;
        });
        for (Map.Entry<Character, Integer> entry : cache.entrySet()) {
            queue.add(new Tuple((char) entry.getKey(), entry.getValue()));
        }

        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()){
            Tuple poll = queue.poll();
            for (int i = 0; i < poll.count; i++) {
                sb.append(poll.c);
            }
        }
        return sb.toString();

    }

    class Tuple{
        public Character c;
        public int count;
        public Tuple(Character c, int count){
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("cccaaa"));
    }
}
