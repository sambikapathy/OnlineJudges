package LeetCode;

public class WordSearch {

	/*
	 * [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ] word =
	 * "ABCCED", -> returns true, word = "SEE", -> returns true, word = "ABCB",
	 * -> returns false.
	 */

	

	public static void main(String[] args) {
		WordSearch search = new WordSearch();
		char[][] board = { 
				{ 'A', 'B', 'C', 'E' }, 
				{ 'S', 'F', 'C', 'S' }, 
				{ 'A', 'D', 'E', 'E' } 
				};
//		String word = "ABCCED";
		String word = "SEE";
//		String word = "ABCB";
		System.out.println(search.exist(board, word));
	}
	static int rs = 0;
	static int cs = 0;
	public boolean exist(char[][] board, String word) {
		rs = board.length;
		cs = board[0].length;

		for (int i = 0; i < rs; i++) {
			for (int j = 0; j < cs; j++) {
				boolean[][] status = new boolean[rs][cs];
				if (backtrack(board, status, i, j, word)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean backtrack(char[][] board, boolean[][] status, int r, int c, String word) {
		if (status[r][c]) {
			return false;
		}
		if (word.length() == 0) {
			return true;
		}
		// for(int i=0;i<word.length();i++){
		char value = word.charAt(0);
		if (value != board[r][c]) {
			return false;
		} else {
			status[r][c] = true;
			if (c - 1 >= 0) {
				if (backtrack(board, status, r, c - 1, word.substring(1))) {
					return true;
				}
			}

			if (c + 1 < cs) {
				if (backtrack(board, status, r, c + 1, word.substring(1))) {
					return true;
				}
			}

			if (r + 1 < rs) {
				if (backtrack(board, status, r + 1, c, word.substring(1))) {
					return true;
				}
			}

			if (r - 1 >= 0) {
				if (backtrack(board, status, r - 1, c, word.substring(1))) {
					return true;
				}
			}
		}
		return false;

		// }
	}
}
