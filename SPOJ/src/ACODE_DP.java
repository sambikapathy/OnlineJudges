

public class ACODE_DP {

	public static void main(String[] args) throws Exception {
		java.io.BufferedReader r = new java.io.BufferedReader(
				new java.io.InputStreamReader(System.in));

		String input = r.readLine();
		while (!(input.startsWith("0"))) {
			long []dp = new long[input.length()+1];
			dp[0]=1;
			dp[1] = 1;
			for(int i=1;i<input.length();i++){
				int cchar = input.charAt(i)- 48;
				int prev = input.charAt(i-1)-48;
				//dp[i] = dp[i-1](in case of single digit ) + dp[i-2] (incase of double digit)
				
				
			}
		}
	}
}
