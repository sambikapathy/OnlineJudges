

public class ADDREV {

	public static void main (String[] args) throws java.lang.Exception
	  {
	     java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
	     int total = Integer.parseInt(r.readLine());
	     for(int i=0;i<total;i++){
	    	 String []str = r.readLine().split(" ");
	    	 int x = getReverse(str[0]);
	    	 int y = getReverse(str[1]);
	    	 System.out.println(getReverse((x+y)+""));
	     }
	  }
	
	private static int getReverse(String number){
		int rev = Integer.parseInt(new StringBuilder(number).reverse().toString());
		return rev;
	}
}
