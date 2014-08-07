import java.util.Scanner;


public class SIZECON {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long sum = 0,value=0,total=in.nextInt();
		for(int i=0;i<total;i++){
			if((value = in.nextInt())>0)
				sum+=value;
		}
		System.out.println(sum);
	}
}
