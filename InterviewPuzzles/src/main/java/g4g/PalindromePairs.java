package g4g;

import java.util.Arrays;

import tree.Trie;

/**
 * Palindrome Pairs question - given a set of words, find all pairs of words
 * that form a palindrome when concatenated. Make sure to know big-O time
 * complexity
 * 
 * @author sambikapathi
 *
 */
public class PalindromePairs {
	/*
	 * abcdc ba cba def aaa a abddc
	 * 
	 * 
	 * abcdc aaa a
	 */
	/*
	 * a aaa abc
	 * 
	 */

	private static Trie constructTrie(String[] input) {
		Trie trie = new Trie();
		Arrays.stream(input).forEach(node -> trie.addNode(node));
		return trie;
	}

	private static void findPalindromicSubstring(String[] input) {
		for (int i = 0; i < input.length - 1; i++) {
			Boolean[] flag = findPalindromicSubstring(input[i]);
			for (int j = i + 1; j < input.length; j++) {

			}
		}
	}

	private boolean isPalindrome() {
		return false;
	}

	// abcdc
	private static Boolean[] findPalindromicSubstring(String input) {
		Boolean[] flag = new Boolean[input.length()];
		for (int i = 0; i < input.length(); i++) {
			int e = input.length() - 1;
			int s = i;
			boolean failed = false;
			while (s < e) {
				if (input.charAt(s++) != input.charAt(e--)) {
					failed = true;
					break;
				}
			}
			flag[i] = !failed;
		}
		return flag;
	}

	public static void main(String[] args) {
		String[] input = { "abcdc", "ba", "cba", "def", "aaa", "a", "abddc" };
		Arrays.stream(findPalindromicSubstring(input[0])).forEach(ID -> System.out.print(ID + " "));
		Trie trie = constructTrie(input);
		trie.printTrie("", trie.getRoot());
	}
}
