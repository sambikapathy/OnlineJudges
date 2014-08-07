import java.math.BigInteger;
import java.util.Scanner;


public class Julka {

	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		BigInteger two = new BigInteger("2");
		for(int i=0;i<10;i++){
			BigInteger total = new BigInteger(z.next());
			BigInteger diff = new BigInteger(z.next());
			BigInteger x = total.add(diff).divide(two);
			System.out.println(x);
			System.out.println(total.subtract(x));
		}
		
	}
}
