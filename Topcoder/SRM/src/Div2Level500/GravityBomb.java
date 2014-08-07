package Div2Level500;

/*
 * Tetris is one of those games that is everywhere; there aren't too many people who haven't seen it in some form or another since its conception in 1985. The concept is fairly simple. You have a vertically-oriented rectangular grid. Pieces, which are made up of some number of 1x1 blocks, fall downwards. Whenever an entire row of the grid is full of blocks, all of the blocks in that row disappear and all the pieces above are shifted downwards by a row.
TopCoder member antimatter is not very good at Tetris. The pieces drop too fast, he says. He's been toying with the idea of coding his own version, with one twist: the addition of the Gravity Bomb, which does not appear on the board. When the Gravity Bomb is activated, if any block is immediately above an empty space, it falls into that space. This process is repeated until there are no more blocks immediately above empty spaces. Then, any completed row of blocks will be removed and the blocks above them shifted downwards, until there are no more complete rows.
The board has a fixed width and height, and the initial state of the board will be represented as a String[] board. The first element of board is the top row, the second element is the row immediately below it, and so on. The character 'X' will represent the presence of a block, and the character '.' will represent an empty space. Your method should return the state of the board after the Gravity Bomb is used, in the same format. Your return value should have the same number of rows and columns as the input.
Definition
    
Class:
GravityBomb
Method:
aftermath
Parameters:
String[]
Returns:
String[]
Method signature:
String[] aftermath(String[] board)
(be sure your method is public)
    

Constraints
-
board will contain between 1 and 50 elements, inclusive
-
each element of board will contain between 1 and 50 characters, inclusive
-
each element of board will be the same length
-
each character in board will be either 'X' or '.'
Examples
0)

    
{"..X",
 "X.X",
 ".X."}
Returns: { "...",  "...",  "..X" }
After the Gravity Bomb is used, the board looks like this: ... ..X XXX Then we remove the completed line at the bottom and move all blocks above downwards.
1)

    
{"...",
 "X..",
 ".X."}
Returns: { "...",  "...",  "XX." }
Here there are no complete lines.
2)

    
{"XXXXXX",
 "......",
 "......"}
Returns: { "......",  "......",  "......" }

3)

    
{"XX.XX....XX"}
Returns: { "XX.XX....XX" }

4)

    
{"X",".",".",".",".",".",".",".",".",".",".",".",".",
 ".",".",".",".",".",".",".",".",".",".",".",".",".",
 ".",".",".",".",".",".",".",".",".",".",".",".",".",
 ".",".",".",".",".",".",".",".",".",".","."}
Returns: 
{ ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  ".",
  "." }

5)

    
{"XXX", "XXX"}
Returns: { "...",  "..." }
 */
public class GravityBomb
{
	public String[] aftermath(String[] board)
	{
		boolean shouldContinue= false;
		for(int i=board.length-2;i>=0;i--){
			StringBuilder sb1 = new StringBuilder(board[i]);
			StringBuilder sb2 = new StringBuilder(board[i+1]);
			
			for(int j=0;j<board[i].length();j++){
				if(board[i].charAt(j)=='X' && board[i+1].charAt(j)=='.'){
					sb2.setCharAt(j,  'X');
					sb1.setCharAt(j,  '.');
					shouldContinue = true;
				}
			}
			board[i] = sb1.toString();
			board[i+1] = sb2.toString();
			
		}
		if(isAllX(board[board.length-1])){
			for(int i=board.length-2;i>=0;i--){
				board[i+1] = board[i];
			}
			StringBuilder sb = new StringBuilder(board[0]);
			for(int i=0;i<board[0].length();i++){
				sb.setCharAt(i, '.');
			}
			board[0] = sb.toString();
			
		}
		
		if(shouldContinue){
			return aftermath(board);
		}else{
			return board;
		}
	}
	
	private boolean isAllX(String str){
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) != 'X'){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		GravityBomb gb = new GravityBomb();
		String []result = gb.aftermath(new String[]{"XXXXXX", "......", "......"});
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
}