package LeetCode;

import java.util.Base64;

public class EncodeandDecodeTinyURL {

	String prefix = "http://tinyurl.com/";

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String hash = new String(Base64.getEncoder().encode(longUrl.getBytes()));
		return prefix + hash;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		if (shortUrl == null || shortUrl.length() <= 6) {
			return null;
		}
		return new String(Base64.getDecoder().decode(shortUrl.split(prefix)[1]));
	}

	public static void main(String[] args) {

		EncodeandDecodeTinyURL encodeandDecodeTinyURL = new EncodeandDecodeTinyURL();
		String input = "https://leetcode.com/problems/design-tinyurl";
		System.out.println(encodeandDecodeTinyURL.decode(encodeandDecodeTinyURL.encode(input)));
	}
}
