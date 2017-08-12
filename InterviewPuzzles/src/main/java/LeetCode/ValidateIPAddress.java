package LeetCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPAddress {

	Pattern ipv4 = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");

	public String validIPAddress(String IP) {
		Matcher m = ipv4.matcher(IP);
		if (m.find()) {
			for (int i = 1; i <= 4; i++) {
				String part = (m.group(i));
				int partInt = Integer.parseInt(part);
				if (part.startsWith("0") || partInt > 255) {
					return "Neither";
				}
			}
			return "IPv4";
		}

		Pattern ipv6 = Pattern.compile(
				"(\\p{Alnum}{1,4})\\:(\\p{Alnum}{1,4})\\:(\\p{Alnum}{1,4})\\:(\\p{Alnum}{1,4})\\:(\\p{Alnum}{1,4})\\:(\\p{Alnum}{1,4})\\:(\\p{Alnum}{1,4})\\:(\\p{Alnum}{1,4})");
		Matcher m2 = ipv6.matcher(IP);
		if (m2.find()) {
			for (int i = 1; i <= 8; i++) {
				String part = (m.group(i));
				System.out.println(part);
			}
			return "IPv4";
		}

		return null;
	}

	public static void main(String[] args) {

		String input = "2001:0db8:85a3:0:0:8A2E:0370:7334";
		System.out.println(new ValidateIPAddress().validIPAddress(input));
	}
}
