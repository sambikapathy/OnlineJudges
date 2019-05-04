package LeetCode.contest.wc80;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MostCommonWord {
/*
Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
 */
    public String mostCommonWord(String paragraph, String[] banned) {

        Map<String,Integer> map = new HashMap<>();
        Set<String> blacklist = new HashSet<>();

        for(int i=0;i<banned.length;i++)blacklist.add(banned[i]);

        int max = 0;
        String word = null;

        for(String input : paragraph.split(" ")){
            input = input.toLowerCase();
            for(int i=0;i<input.length();i++){
                if(!Character.isLetter(input.charAt(i))){
                    input = input.substring(0,i);
                    break;
                }
            }
            if(blacklist.contains(input)){
                continue;
            }
            Integer freq = map.get(input);
            if(freq == null){
                freq = 1;
            }else{
                freq = freq+1;
            }

            map.put(input,freq);
            if(freq> max){
                max = freq;
                word = input;
            }
        }
        return word;
    }

    public static void main(String[] args) {

        String para = "Bob hit a ball, the hit BALL,! flew far after it was hit.";
        String [] banned = {"hit"};
        System.out.println(new MostCommonWord().mostCommonWord(para,banned));
    }

}
