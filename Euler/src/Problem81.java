import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Problem81 {

	private static final File source = new File("./src/matrix.txt");
	private static int rl = 80, cl = 80;
	private static int[][] array = new int[80][80];
	private static long recursionCount = 0;
	private static long pathCount = 0;

	private static String getFileContent(File file) {
		try {
			String temp;
			System.out.println(file.getAbsolutePath());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			int index = 0;
			while ((temp = reader.readLine()) != null) {
				int col = 0;
				for (String str : temp.split(",")) {
					array[index][col++] = Integer.parseInt(str);
				}
				index++;
			}
		} catch (Exception e) {

		}
		return "";
	}

	private static int minSum = Integer.MAX_VALUE;

	private static void traverseMatrix(int sum, int row, int col) {

		recursionCount++;
		if (row > 79 || col > 79) {
			return;
		}
		if ((sum + array[row][col]) < minSum) {
			if(recursionCount % 100000000 == 0)
//				System.out.println(row + " " + col + " " + sum);
			
			if (row == 79 && col == 79) {
				sum += array[row][col];
				if (sum < minSum) {
					minSum = sum;
					System.out.println("New Sum :: " + minSum);
				}
				pathCount++;
				System.out.println("Found Path :" + pathCount);
				return;
			}
			traverseMatrix(sum + array[row][col], row, col + 1);
			traverseMatrix(sum + array[row][col], row + 1, col);
			return;
		}
	}

	private static void printMatrix() {
		for (int i = 0; i < 80; i++) {
			for (int j = 0; j < 80; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		getFileContent(source);
		// printMatrix();
		traverseMatrix(0, 0, 0);

		System.out.println("Minimum Sum ::" + minSum);
	}
}
