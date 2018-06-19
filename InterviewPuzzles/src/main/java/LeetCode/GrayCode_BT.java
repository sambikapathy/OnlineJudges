package LeetCode;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class GrayCode_BT {

	static BitSet flag = null;

	public static List<Integer> grayCode(int n) {

		List<Integer> result = new ArrayList<>();
		result.add(0);
		result.add(1);
		flag.set(0);
		flag.set(1);
		if (n <= 1) {
			return result;
		}
		return null;

	}

	public static void main(String[] args) {
		int n = 2;
		flag = new BitSet(n);
		grayCode(n);
	}
}
