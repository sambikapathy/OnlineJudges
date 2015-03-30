import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class P96Sudoku {

	private static List<Integer[][]> getFileContent(File file) {
		List<Integer[][]> inputArrays = new ArrayList<Integer[][]>();
		try {
			String temp;
			System.out.println(file.getAbsolutePath());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((temp = reader.readLine()) != null) {
				Integer [][] array = new Integer[9][9];
				for(int i=0;i<9;i++){
					temp = reader.readLine();
					for(int j=0;j<9;j++){
						array[i][j] = temp.charAt(j)-'0';
					}
				}
				inputArrays.add(array);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputArrays;
	}
	private static void printSudoku(Integer [][]input){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(input[i][j]);
			}
			System.out.println();
		}
	}
	
	
	
	private static String getSudokuSum(Integer[][] input){
		Stack<Position> backtrackStack = new Stack<P96Sudoku.Position>();
		boolean isBackTrack = false;
		for(int i=0;i<9;){
			for(int j=0;j<9;){
				if(input[i][j] == 0 || isBackTrack){
					isBackTrack = false;
					boolean isValueFound = false;
					for(int k=input[i][j]+1;k<=9;k++){
						if(isValidPosition(i, j, k, input)){
							input[i][j] = k;
							backtrackStack.add(new Position(i, j, k));
							isValueFound = true;
							break;
						}
					}
					if(!isValueFound){
						input[i][j]=0;
						Position pos = backtrackStack.pop();
						i=pos.i;
						j = pos.j;
						isBackTrack = true;
					}else{
						j++;
					}
				}else{
					j++;
					continue;
				}
				
			}
			i++;
		}
		//printSudoku(input);
		return input[0][0]+""+input[0][1]+""+input[0][2];
	}

	
	private static boolean isValidPosition(int i , int j , int value , Integer[][] input){
		for(int r = 0;r<9;r++){
			if(input[r][j] == value){
				return false;
			}
		}
		for(int c = 0;c<9;c++){
			if(input[i][c] == value){
				return false;
			}
		}
		
		int r = (i/3)*3;
		int c = (j/3)*3;
		for(int x=0;x<3;x++){
			for(int y=0;y<3;y++){
				if(input[x+r][y+c]==value){
					return false;
				}
			}
		}
		return true;
	}
	
	static class Position{
		public int i;
		public int j;
		public int value;
		public Position(int i , int j , int value){
			this.i = i;
			this.j = j;
			this.value = value;
		}
	}
	
	
	
	public static void main(String[] args) {
		List<Integer[][]> input = getFileContent(new File("./src/sudoku.txt"));
//		printSudoku(input.get(0));
//		System.out.println("\n\n");
		BigInteger total = new BigInteger("0");
		for (Integer[][] array : input) {
			total = total.add(new BigInteger(getSudokuSum(array)));
		}
		System.out.println(total.toString());
	}
}
