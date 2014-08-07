import java.util.Scanner;


public class EASYPROB {

	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
//		int input = z.nextInt();
		int value = 1315;
		while(value > 0){
			
			int power = (closetPower(value));
			int sub = (int) Math.pow(2, power);
			System.out.println(sub);
			value-=sub;
		}
		
	}
	
	static int closetPower(int target){
		int start = 0;
		int total =0;
		while(total < target){
			total+= Math.pow(2, start++);
		}
		return start-1;
	}
}
