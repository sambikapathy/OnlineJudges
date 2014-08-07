import java.util.HashMap;


public class COINS {
	
	private static HashMap<Long, Long> map = new HashMap<Long, Long>();

	public static void main(String[] args) throws Exception{
		java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
	    String s;
	    while((s=r.readLine())!=null){
	    	long x = Long.parseLong(s);
	    	System.out.println(findValue(x));
	    }
	}
	
	private static long findValue(long x){
		if(map.containsKey(x)) return map.get(x);
		if(x<=3) {
			map.put(x, x);
			return x;
		}
		
		long total =  findValue(x/2)+findValue(x/3)+findValue(x/4);
		if(total < x) {
			map.put(x, x);
			return x;
		}
		map.put(x, total);
		return total;
	}
}
