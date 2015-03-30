import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem25Fibonacci1000Digit {

	static BigInteger TWO = new BigInteger("2");
	static Map<BigInteger, BigInteger> map = new HashMap<BigInteger, BigInteger>();

	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			String input = (fibonacci(new BigInteger(i + "")).toString());
			if (input.length() == 1000) {
				System.out.println(i);
				break;
			}
		}
	}

	private static BigInteger fibonacci(BigInteger input) {
		if (input.equals(BigInteger.ONE) || input.equals(BigInteger.ZERO)) {
			return input;
		} else if (map.containsKey(input)) {
			return map.get(input);
		}

		BigInteger result = fibonacci(input.subtract(BigInteger.ONE)).add(
				fibonacci(input.subtract(TWO)));

		map.put(input, result);
		return result;
	}

}
