import java.util.HashMap;
import java.util.Map;


public class P27QuadraticPrimes {

	static Map<Integer , Boolean> isPrimeMap = new HashMap<Integer,Boolean>();
	public static void main(String[] args) {
		//n2 + an + b
		int max = 0;
		for(int a = -1000;a<=1000;a++){
			for(int b=-1000;b<=1000;b++){
				int count = 0;
				for(int n=0;n<=100;n++){
					int total = n*n + a*n + b;
					if(isPrime(total)){
						count++;
					}else{
						if(max < count){
							max = count;
							System.out.println(max + " "+ a*b);
						}
						break;
					}
				}
			}
		}
		System.out.println(max);
	}
	
	
	static boolean isPrime(int value){
		value = Math.abs(value);
		if(isPrimeMap.containsKey(value)){
			return isPrimeMap.get(value);
		}
		if(value % 2 == 0){
			return false;
		}
		for(int i=3;i<Math.sqrt(value);i+=2){
			if(value%i ==0){
				isPrimeMap.put(value, false);
				return false;
			}
		}
		isPrimeMap.put(value, true);
		return true;
	}
	
}
