import java.util.Scanner;


public class AP2 {

	public static void main(String[] args) throws java.lang.Exception {
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();
		for(int i=0;i<total;i++){
			printSeries(in.nextLong(),in.nextLong(),in.nextLong());
		}
	}
	
	
	private static void printSeries(long three , long lastThree , long sum){
		long n = (sum*2) / (three+lastThree);
		long d = (lastThree-three)/(n-5);
		long a1 = three-(2*d);
		System.out.println(n);
		for(int i=0;i<n;i++){
			System.out.print(a1+(i*d)+" ");
		}
		System.out.println();
	}
}
