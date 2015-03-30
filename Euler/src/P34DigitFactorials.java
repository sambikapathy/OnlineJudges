import java.util.HashMap;
import java.util.Map;


public class P34DigitFactorials {

	static Map<Integer, Integer> factorialMap = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		for(int i=3;i<20000000;i++){
			String input = String.valueOf(i);
			int total = 0;
			for(int j=0;j<input.length();j++){
				total+= (getFactorial(input.charAt(j)-'0'));
			}
			if(total == i){
				System.out.println(i);
			}
		}
	}
	
	private static int getFactorial(int value){
		if(factorialMap.containsKey(value)){
			return factorialMap.get(value);
		}
		int result =1;
		for(int i=1;i<=value;i++){
			result*= i;
		}
		factorialMap.put(value, result);
		return result;
	}
}
