import java.math.BigInteger;
import java.util.Scanner;


public class BISHOPS {

	public static void main(String[] args) {
		BigInteger two = new BigInteger("2");
		Scanner z = new Scanner(System.in);
		while(z.hasNextBigInteger()){
			BigInteger value = z.nextBigInteger();
			if(value.equals(BigInteger.ONE)){
				System.out.println("1");
			}else{
				System.out.println(value.subtract(BigInteger.ONE).multiply(two).toString());
			}
		}
	}
}
