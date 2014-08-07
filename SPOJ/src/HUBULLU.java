import java.util.Scanner;


public class HUBULLU {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int cases = in.nextInt();
		while(cases--!=0){
			int n = in.nextInt();
			int p = in.nextInt();
			if(p==0){
				System.out.println("Airborne wins.");
			}else{
				System.out.println("Pagfloyd wins.");
			}

		}

	}

}
