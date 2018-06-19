package g4g;

public class AlphaNumericAbbreviation {

	public void printAbbreviatedStrings(String input, String prefix) {
		if (input.length() == 0) {
			System.out.println(prefix);
			return;
		}
		int i = 0;
		String substring = i + 1 > input.length() ? "" : input.substring(i + 1);
		printAbbreviatedStrings(substring, prefix + input.charAt(i));

		char lastChar = prefix.length() > 0 ? prefix.charAt(prefix.length() - 1) : ' ';
		if (lastChar >= '0' && lastChar <= '9') {
			printAbbreviatedStrings(substring, prefix.substring(0, prefix.length() - 1) + ((char) (lastChar + 1)));
		} else {
			printAbbreviatedStrings(substring, prefix + "1");
		}
	}

	public static void main(String[] args) {
		new AlphaNumericAbbreviation().printAbbreviatedStrings("ANKS", "");
	}
}
