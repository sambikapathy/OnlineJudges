import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PPATH {

	public static void main(String[] args) {
		System.out.println(isPrime(8776));
	}
	public static void main1(String[] args) throws Exception {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(f.readLine());
		int h = parseInt(st.nextToken());
		for(int i=0;i<h;i++){
			st = new StringTokenizer(f.readLine());
			int start = parseInt(st.nextToken());
			int end = parseInt(st.nextToken());
			
		}
	}
	
	
	private static boolean isPrime(int number){
		for(int i=3;i<Math.sqrt(number);i+=2){
			if(number%i==0){
				return false;
			}
		}
		return true;
	}
}
