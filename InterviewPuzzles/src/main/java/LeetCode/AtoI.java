package LeetCode;

public class AtoI {

	public int myAtoi(String str) {
		long result = 0l;
		str = str.trim();
		boolean negative = false;
		if (str.length() > 0) {
			char[] array = str.toCharArray();
			int i = 0;
			if (array[0] == '-' || array[0] == '+') {
				negative = (array[0] == '-');
				i = 1;
			}
			for (; i < array.length; i++) {
				if (array[i] >= '0' && array[i] <= '9') {
					result = (result * 10L + Long.valueOf(array[i] - '0'));
				} else {
					break;
				}

				long temp = result;
				if (negative) {

					temp = result * -1;
				}
				if (temp > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				} else if (temp < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}

			}
		}

		if (negative) {

			result = result * -1;
		}
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int) result;
	}

	public static void main(String[] args) {
		System.out.println(new AtoI().myAtoi("9223372036854775809"));
	}
}
