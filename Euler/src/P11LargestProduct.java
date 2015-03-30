import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class P11LargestProduct {

	private static long[][] getFileContent(File file) {
		try {
			String temp;
			System.out.println(file.getAbsolutePath());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			long[][] array = new long[20][20];

			for (int i = 0; i < 20; i++) {
				temp = reader.readLine();
				String []values = temp.split(" ");
				for(int j = 0;j<20;j++){
					array[i][j] = Integer.parseInt(values[j]);
				}
			}
			reader.close();
			return array;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private static long getMaxValue(long [][]input){
		long max = 0;
		for(int i=0;i<20;i++){
			for(int j=0;j<20-3;j++){
				long value = input[i][j]*input[i][j+1]*input[i][j+2]*input[i][j+3];
				if(value > max){
					max = value;
				}
			}
		}
		
		for(int i=0;i<20-3;i++){
			for(int j=0;j<20;j++){
				long value = input[i][j]*input[i+1][j]*input[i+2][j]*input[i+3][j];
				if(value > max){
					max = value;
				}
			}
		}
		
		for(int i=0;i<20-3;i++){
			for(int j=0;j<20;j++){
				long value = input[i][j]*input[i+1][j]*input[i+2][j]*input[i+3][j];
				if(value > max){
					max = value;
				}
			}
		}
		
		for(int i=0;i<20-3;i++){
			for(int j=0;j<20-3;j++){
				long value = input[i][j]*input[i+1][j+1]*input[i+2][j+2]*input[i+3][j+3];
				if(value > max){
					max = value;
				}
			}
		}
		
		for(int i=3;i<20;i++){
			for(int j=0;j<20-3;j++){
				long value = input[i][j]*input[i-1][j+1]*input[i-2][j+2]*input[i-3][j+3];
				if(value > max){
					max = value;
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(getMaxValue(getFileContent(new File("./src/product.txt"))));
	}
}
