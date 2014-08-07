import java.util.Scanner;


public class CANDY {

	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		int size = z.nextInt();
		while(size != -1){
			long x [] = new long[size];
			long total = 0;
			for(int i=0;i<size;i++){
				x[i] = z.nextInt();
				total += x[i];
			}
			if(total % size == 0){
				long div = total / size;
				long sum = 0;
				for(int i=0;i<size;i++){
					if(div < x[i]){
						
					}else{
						sum+= div- x[i];
					}
				}
				System.out.println(sum);
			}else{
				System.out.println(-1);
			}
			size = z.nextInt();
		}
		
	}
}
