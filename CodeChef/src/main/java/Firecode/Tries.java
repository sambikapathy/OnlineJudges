package Firecode;

import java.util.HashMap;

public class Tries {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insertWord("FIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRES");
		trie.insertWord("FIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESA");
		trie.insertWord("FIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESB");

		for (int i = 0; i < 1000; i++) {
			System.out.println(trie.searchPrefix("FIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRESFIRES"));
		}
	}
}

class TrieNode {
	Character c;
	Boolean isLeaf = false;
	HashMap<Character, TrieNode> children = new HashMap<>();

	public TrieNode() {
	}

	public TrieNode(Character c) {
		this.c = c;
	}
}

class Trie {
	private TrieNode root;

	// Implement these methods :
	public Trie() {
		root = new TrieNode();
	}

	public void insertWord(String word) {
		if (word == null || word.length() == 0) {
			return;
		}
		TrieNode start = root;
		char[] array = word.toCharArray();
		for (int i = 0; i < array.length; i++) {
			char c = array[i];
			if (start.children.containsKey(c)) {
				start = start.children.get(c);
				if (i == array.length - 1) {
					start.isLeaf = true;
				}
			} else {
				TrieNode temp = new TrieNode(c);
				start.children.put(c, temp);
				start = temp;
			}
		}
	}

	public Boolean searchWord(String word) {
		if (word == null || word.length() == 0) {
			return false;
		}
		TrieNode start = root;
		char[] array = word.toCharArray();
		TrieNode temp = null;
		for (int i = 0; i < array.length; i++) {
			temp = start.children.get(array[i]);
			if (start == null || temp == null) {
				return false;
			} else {
				start = temp;
			}
		}
		return temp.isLeaf;
	}

	public Boolean searchPrefix(String word) {
		TrieNode start = root;
		char[] array = word.toCharArray();
		for (int i = 0; i < array.length; i++) {
			TrieNode temp = start.children.get(array[i]);
			if (temp == null) {
				return false;
			} else {
				start = temp;
			}
		}
		return true;
	}
}
