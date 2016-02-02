package LeetCode;

import java.util.HashMap;

public class InterleavingString {
	/*
	 * Given: s1 = "aabcc", s2 = "dbbca",
	 * 
	 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return
	 * false.
	 * 
	 * s1= abc s2 = abc s3 = abcabc
	 * 
	 * 
	 * s1 = abd s2 = abe s3 : abeabd
	 */
	private HashMap<String, Boolean> result = new HashMap<String, Boolean>();
	public static void main(String[] args) {
//		 String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
//		String s1 = "abc", s2 = "abc", s3 = "abcabc";
//		 String s1 = "aa", s2 = "ab", s3 = "aaba";
		String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", 
				s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", 
				s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		// "aa", "ab", "aaba" -> true
//		"bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"
		if(s1.length() + s2.length() != s3.length()){
		//	return false;
		}
		System.out.println(new InterleavingString().isInterleave2(s1, s2, s3));
	}

	// recursion???
//	public boolean isInterleave(String s1, String s2, String s3) {
//		if (s1.length() + s2.length() != s3.length()) {
//			return false;
//		}
//		int i3 = 0;
//		StringBuilder sb = new StringBuilder();
//		boolean isAmbi = false;
//		while (s3.length() > 0 && i3 < s3.length()) {
//			sb.append(s3.charAt(i3));
//			boolean is1 = s1.startsWith(sb.toString());
//			boolean is2 = s2.startsWith(sb.toString());
//			if (is1 && !is2) {
//				s1 = s1.substring(sb.length());
//				s3 = s3.substring(sb.length());
//				sb.delete(0, sb.length());
//				isAmbi = false;
//				i3 = 0;
//			} else if (!is1 && is2) {
//				s2 = s2.substring(sb.length());
//				s3 = s3.substring(sb.length());
//				sb.delete(0, sb.length());
//				isAmbi = false;
//				i3 = 0;
//			} else if (!isAmbi && !is1 && !is2) {
//				return false;
//			} else {
//				isAmbi = true;
//				i3++;
//			}
//		}
//		// s3 = s3.substring(i3);
//		if (s1.length() + s2.length() == 0 || (s1 + s2).equals(s3)
//				|| (s2 + s1).equals(s3)) {
//			return true;
//		}
//		return false;
//	}

	public boolean isInterleave2(String s1, String s2, String s3) {
		if(s1.length()==0 && s2.length()==0 && s3.length()==0){
			return true;
		}
		
		char c = s3.charAt(0);
		
		if (s1.length() > 0 && s1.startsWith(c + "")) {
			if(result.containsKey(s1+":"+s2+":"+s3+":s1")){
				return result.get(s1+":"+s2+":"+s3+":s1");
			}
			if(isInterleave2(s1.substring(1), s2, s3.substring(1))){
				return true;
			}else{
				result.put(s1+":"+s2+":"+s3+":s1",false);
			}
		}

		if (s2.length() >0 && s2.startsWith(c + "")) {
			if(result.containsKey(s1+":"+s2+":"+s3+":s2")){
				return result.get(s1+":"+s2+":"+s3+":s2");
			}
			if(isInterleave2(s1, s2.substring(1), s3.substring(1))){
				return true;
			}else{
				result.put(s1+":"+s2+":"+s3+":s2",false);
			}
		}
		return false;
	}
}
