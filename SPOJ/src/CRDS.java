import java.io.IOException;


public class CRDS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
	     int total = Integer.parseInt(r.readLine());
	     long mod = 1000007;
	     for(int i=0;i<total;i++){
	    	 long no = Long.parseLong(r.readLine())%mod;
	    	 long result = (no * (no+1))%mod;
	    	 result +=((no*(no-1))/2);
	    	 result%=mod;
	    	 System.out.println(result);
	     }
	}
}
