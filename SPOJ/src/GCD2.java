import java.math.BigInteger;
import java.util.Scanner;

public class GCD2 {

	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		int total = z.nextInt();
		for (int i = 0; i < total; i++) {
			BigInteger result = gcd(new BigInteger(z.next()),
					new BigInteger(z.next()));
			System.out.println(result);
		}
	}

	static BigInteger gcd(BigInteger a, BigInteger b) {
		if (b.intValue() == 0)
			return a;
		else
			return gcd(b, a.mod(b));
	}
}
