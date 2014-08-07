import java.util.Scanner;

public class HANGOVER {
	public static void main(String[] args) throws Exception{
		Scanner z = new Scanner(System.in);
		while(true){
			double result = z.nextDouble();
			if(result <=0.0){
				break;
			}
			double total = 0;
			for(int i=2;i<100000;i++){
				total+= 1.0/i;
				if(total >= result){
					System.out.println(i-1 +" card(s)");
					break;
				}
			}
		}
	}
}
