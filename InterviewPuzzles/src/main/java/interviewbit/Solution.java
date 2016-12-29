package interviewbit;

import java.math.BigInteger;

public class Solution {
	public int pow(long x, long n, long d) {
		if (n == 0) {
			return (int) (1 % d);
		}
		long value = pow2(Long.valueOf(x), Long.valueOf(n), d);
		if (value < 0) {
			while (value < 0) {
				value = value + d;
			}
		}
		return (int) (value % d);

	}

	public long pow2(Long x, Long y, Long d) {

		if (y == 0) {
			return 1;
		}

		BigInteger ans = new BigInteger(x + "");
		BigInteger res = BigInteger.ONE;
		BigInteger mod = new BigInteger(d + "");
		while (y > 0) {
			if ((y & 1) != 0) {
				res = res.multiply(ans).mod(mod);
				// System.out.println(res);
			}

			y /= 2;
			ans = ans.multiply(ans).mod(mod);
		}
		return res.longValue();

	}

	public long pow3(long x, long y, long d) {

		if (y == 0) {
			return 1;
		}

		long square = x;
		long ans = 1l;

		while (y != 0) {
			if (y % 2 == 1) {
				ans = (ans * square);
			}
			y = y / 2;
			square = (square * square) % d;
			if (ans > d) {
				ans = ans % d;
			}
		}
		return ans;

	}

	// x ^ n = (x * x) ^ n/2

	public long pow4(long x, long y, long d) {

		if (y == 0) {
			return 1;
		}
		if (y == 1) {
			return x;
		}

		long z = 1;

		while (y > 1) {
			if (y % 2 == 0) {
				x = x * x;
				y = y / 2;
			} else {
				z = x * z;
				x = x * x;
				y = (y - 1) / 2;
			}
		}
		return x * z;

	}

	// 72611807
	public static void main(String[] args) {
		// System.out.println(57263970*57263970);
		// System.out.println(57263970l*57263970l);
		System.out.println(new Solution().pow(79161127l, 99046373l, 57263970l));
		System.out.println(new Solution().pow4(79161127l, 99046373l, 57263970l));

		// System.out.println(new Solution().pow(10, 3, 2));
	}
}
