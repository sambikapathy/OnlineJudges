import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Problem81 {

	private static final File source = new File("./src/matrix.txt");
	private static int[][] array = new int[80][80];

	private static void getFileContent(File file) {
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
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private static int getMinSum(int size){
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if(i==0 && j==0) continue;
				int left = i-1>=0?array[i-1][j]:-1;
				int top = j-1 >= 0 ? array[i][j-1]:-1;
				int valuel = Integer.MAX_VALUE ,valuet = Integer.MAX_VALUE;
				if(left != -1) valuel = left+array[i][j];
				if(top != -1) valuet = top+array[i][j];
				
				
				
				if(valuel < valuet){
					array[i][j] = valuel;
				}else{
					array[i][j] = valuet;
				}
			}
		}
		return array[size-1][size-1];
	}
	public static void main(String[] args) {
		getFileContent(source);
		System.out.println(getMinSum(80));
	}
}
