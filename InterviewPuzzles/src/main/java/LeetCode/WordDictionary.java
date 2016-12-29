package LeetCode;

public class WordDictionary {

	private TrieNode root;
	
	public WordDictionary(){
		root = new TrieNode();
	}
    // Adds a word into the data structure.
    public void addWord(String word) {
    	TrieNode start = root;
        for(int i=0;i<word.length();i++){
        	TrieNode t = start.input[word.charAt(i)-'a'];
        	if(t == null){
        		TrieNode newNode = new TrieNode();
        		newNode.value=word.charAt(i);
        		t = start.input[word.charAt(i)-'a'] = newNode;
        	}
        	start = t;
        }
        start.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
//    public boolean search(String word) {
//    	TrieNode start = root;
//    	 for(int i=0;i<word.length();i++){
//         	TrieNode t = start.input[word.charAt(i)-'a'];
//         	if(t == null){
//         		return false;
//         	}
//         	start = t;
//         }
//    	 return start.isWord;
//    }
    
	public boolean search(String word) {
		return search(word, root);
	}

	public boolean search(String word, TrieNode start) {
		if(word.length() == 0){
			return start.isWord;
		}
		char c = word.charAt(0);
		if (c != '.') {
			TrieNode t = start.input[c - 'a'];
			if (t == null) {
				return false;
			}
			return search(word.substring(1), t);
		} else {
			for (int i = 0; i < 26; i++) {
				if (start.input[i] != null) {
					if (search(word.substring(1), start.input[i])) {
						return true;
					}
				}
			}
			return false;
		}

	}
    
    public static void main(String[] args) {
    	 WordDictionary wordDictionary = new WordDictionary();
    	 wordDictionary.addWord("word");
    	 System.out.println(wordDictionary.search("w.rd"));
    	 System.out.println(wordDictionary.search("word"));
	}
}
