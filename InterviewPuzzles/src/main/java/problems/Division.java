package problems;

public class Division {

	static int MAX_PRECISION = 10;
	public static void main(String[] args) {
		for(long i=1;i<10;i++){
			for(long j=1;j<10;j++){
				System.out.println(i+"/"+j + " = "+ divide(i, j) +" "+ (i*1.0/j*1.0));
			}
		}
	}
	private static double divide(long nu , long de){
		long [] result = divisor(nu, de);
		long divisor = result[0];
		long reminder = result[1];
		
		long precision = 0;
		
		long rem = 0;
		while(precision < MAX_PRECISION && reminder > 0){
			long []value  = divisor(reminder*10 , de);
			rem= rem*10 + value[0];
			reminder = value[1];
			precision++;
		}
		return divisor*1.0f+(rem*1.0/MAX_PRECISION*10);
	}
	
	private static long[] divisor(long nu , long de){
		long quotient = 0;
		long nu1 = nu , de1 = de;
		if(nu < de){
			return new long[]{0,nu};
		}
		while(true){
			if(nu1-de1 >= 0){
			nu1-= de1;
			quotient++;
			}else{
				break;
			}
		}
		return new long[]{quotient,nu1};
	}
}
