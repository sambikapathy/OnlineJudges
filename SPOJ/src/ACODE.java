import java.util.HashMap;

public class ACODE {
	static HashMap<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String[] args) throws Exception {
		java.io.BufferedReader r = new java.io.BufferedReader(
				new java.io.InputStreamReader(System.in));

		String input = r.readLine();
		while (!(input.startsWith("0"))) {
			int total = getAllCombinations(input.charAt(0) + "",
					input.substring(1));
			if (input.length() > 1) {
				total += getAllCombinations(input.substring(0, 2),
						input.substring(2));
			}
			System.out.println(total);
			map.clear();
			map = new HashMap<String, Integer>();
			input = r.readLine();
		}
	}

	// 1018 use case
	/*
	 * 17221->6 172210->4 1722101->4 17221012->8 34->1 23->2 1017->2
	 */
	private static int getAllCombinations(String current, String suffix) {

		if (current.startsWith("0")) {
			return 0;
		}
		if (current.length() > 0) {
			int cu = Integer.parseInt(current);
			if (!(cu >= 1 && cu <= 26))
				return 0;
		} else {
			return 0;
		}

		if (suffix.length() == 0) {
			// System.out.println(pre+"-"+current+"-"+suffix);
			map.put(current + ":" + suffix, 1);
			return 1;
		} else {
			if (map.containsKey(current + ":" + suffix)) {
				return map.get(current + ":" + suffix);
			}
			int suffLength = suffix.length();
			int total = 0;
			total += getAllCombinations(suffix.charAt(0) + "",
					suffix.substring(1));
			if (suffLength > 1) {
				total += getAllCombinations(suffix.substring(0, 2),
						suffix.substring(2));
			}
			// System.out.println(pre+"-"+current+"-"+suffix);
			map.put(current + ":" + suffix, total);
			return total;
		}
	}

}