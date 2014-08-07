import java.math.BigInteger;


public class FCTRL2 {

	public static void main (String[] args) throws java.lang.Exception
	  {
	     java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
	     int count = Integer.parseInt(r.readLine());
	     for(int i=0;i<count;i++){
	    	 System.out.println(getFactorialZeros(Long.parseLong(r.readLine())));
	     }
	  }
	
	private static  String getFactorialZeros(long no){
		BigInteger total = new BigInteger("1");
		for(long i=1;i<=no;i++){
			total = total.multiply(new BigInteger(""+i));
		}
		return total.toString();
	}
	

}
