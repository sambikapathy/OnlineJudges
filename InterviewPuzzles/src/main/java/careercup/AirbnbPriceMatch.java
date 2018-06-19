package careercup;

public class AirbnbPriceMatch {
	/**
	 * Q) Given a list of menu items and prices. Print all combinations that
	 * match a target price. Eg: target = $3, Menu( A:$1 , B:$2)
	 * 
	 * Print A,A,A A,B
	 * 
	 * But no B,A
	 */

	// Do a non recursive routine
	private static void priceMatch(int[] menu, int current, int total, int index1, String prefix) {

	}

	private static void priceMatch_recursive(int[] menu, int current, int total, int index1, String prefix) {
		if (current == total) {
			System.out.println(prefix);
		}
		for (int i = index1; i < menu.length; i++) {
			int temp = menu[i] + current;
			if (temp <= total) {
				priceMatch(menu, temp, total, i, prefix + (i + 1));
			}
		}
	}

	public static void main(String[] args) {
		int[] menu = { 3, 7 };
		int total = 8;
		priceMatch(menu, 0, total, 0, "");
	}

}
