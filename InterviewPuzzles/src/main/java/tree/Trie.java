package tree;

public class Trie {

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public TrieNode getRoot() {
		return root;
	}

	public void addNode(String input) {
		TrieNode temp = root;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			int index = c - 'a';
			if (temp.children[index] == null) {
				temp.children[index] = new TrieNode();
			}
			temp = temp.children[index];
		}
		temp.count++;
	}

	public void printTrie(String prefix, TrieNode root) {

		if (root != null) {
			if (root.count > 0) {
				System.out.println(prefix);
			}
			for (int i = 0; i < 26; i++) {

				if (root.children[i] == null)
					continue;

				char c = (char) ('a' + i);

				printTrie(prefix + c, root.children[i]);
			}
		}
	}

	public static void main(String[] args) {
		String[] input = { "cat", "abc", "ant", "tree", "call", "cata" };
		Trie root = new Trie();
		for (String str : input) {
			root.addNode(str);
		}

		root.printTrie("", root.root);
	}
}

class TrieNode {
	TrieNode[] children = new TrieNode[26];
	int count;

}