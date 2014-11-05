import java.util.Scanner;

public class MARBLES {

	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		int total = z.nextInt();
		for (int i = 0; i < total; i++) {
			int n = z.nextInt();
			int k = z.nextInt();
			long fn = factorial(n);
			long fk = factorial(k);
			long fnk = factorial(n-k);
			System.out.println(fn/(fk*fnk));
		}
	}

	public static long factorial(int n) {
		long fact = 1; // this will be the result
		for (long i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}

}
