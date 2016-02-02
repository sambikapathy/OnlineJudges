package LeetCode;

public class MaximalRectangle {

	public static void main(String[] args) {
		new MaximalRectangle().maximalRectangle(null);
	}

	public int maximalRectangle(char[][] matrix) {
		int max1 = findVertical(matrix);
		int max2 = findHorizontal(matrix);
		return max1>max2?max1:max2;
	}
/*
0 0 1 1 0
1 1 1 1 0
1 1 1 1 0
1 1 0 0 0
1 1 1 1 0 
1 1 1 1 0



0 0 5 5 0
1 1 5 5 0
1 1 5 5 0


 */
	private int findVertical(char[][] matrix) {
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 'v'){
					break;
				}
				
				if(matrix[i][j] == '0'){
					continue;
				}
				
				
				
				
			}
		}
		return max;
	}

	private int findHorizontal(char[][] matrix) {
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

			}
		}
		return max;

	}
}