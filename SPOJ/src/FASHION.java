import java.util.Arrays;
import java.util.Scanner;


public class FASHION {

	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		int total = z.nextInt();
		long result=0;
		for(int i=0;i<total;i++){
			int size = z.nextInt();
			int []x = new int[size];
			int []y = new int[size];
			
			for(int j=0;j<size;j++){
				x[j] = z.nextInt();
			}
			for(int j=0;j<size;j++){
				y[j] = z.nextInt();
			}
			Arrays.sort(x);
			Arrays.sort(y);
			for(int j=0;j<size;j++){
			result+= x[j]*y[j];
			}
			System.out.println(result);
			result = 0;
		}
		
	}
}
