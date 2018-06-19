package LeetCode;

import java.util.Arrays;
import java.util.List;

public class WordLadder {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		return -1;
	}

	public static void main(String[] args) {

		String start = "hit";
		String end = "cog";
		List<String> wordList = Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" });

		System.out.println(new WordLadder().ladderLength(start, end, wordList));
	}
}
