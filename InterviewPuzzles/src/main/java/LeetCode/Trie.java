package LeetCode;

class TrieNode {
	TrieNode[] input = new TrieNode[26];
	char value;
	boolean isWord;
}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode start = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode t = start.input[word.charAt(i) - 'a'];
			if (t == null) {
				TrieNode newNode = new TrieNode();
				newNode.value = word.charAt(i);
				t = start.input[word.charAt(i) - 'a'] = newNode;
			}
			start = t;
		}
		start.isWord = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode start = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode t = start.input[word.charAt(i) - 'a'];
			if (t == null) {
				return false;
			}
			start = t;
		}
		return start.isWord;
	}
	
	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String word) {
		TrieNode start = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode t = start.input[word.charAt(i) - 'a'];
			if (t == null) {
				return false;
			}
			start = t;
		}
		return true;
	}
}