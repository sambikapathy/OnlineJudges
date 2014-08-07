

public class FCTRL {

	public static void main (String[] args) throws java.lang.Exception
	  {
	     java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
	     int count = Integer.parseInt(r.readLine());
	     for(int i=0;i<count;i++){
	    	 System.out.println(getFactorialZeroes(Long.parseLong(r.readLine())));
	     }
	  }
	
	private static long getFactorialZeroes(long no){
		long total = 0;
		boolean valid = true;
		long divisor = 5;
		while(valid){
			long value = no/divisor;
			if(value>0){
				total += value;
				divisor*=5;
			}else{
				valid = false;
			}
		}
		return total;
	}
	
	/*private static  long getFactorialZeros(long no){
		BigInteger total = new BigInteger("1");
		for(long i=1;i<=no;i++){
			total = total.multiply(new BigInteger(""+i));
		}
		return getZeros(total.toString());
	}

	private static long getZeros(String string) {
		String s = new StringBuilder(string).reverse().toString();
		long total = 0;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c=='0'){
				total++;
			}
			else{
				break;
			}
		}
		return total;
	}*/
}
