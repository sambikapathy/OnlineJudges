import java.util.Scanner;


public class LASTDIG {

	
	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		int total = z.nextInt();
		for(int i=0;i<total;i++){
			int a = z.nextInt()%10;
			int b = z.nextInt();
			if(a==0)System.out.println(1);
			if(a==1||a==5||a==6)System.out.println(a);
			System.out.println((int)Math.pow(a, b)%10);
		}
		
	}
	
	/*public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		int total = z.nextInt();
		for(int i=0;i<total;i++){
			int a = z.nextInt();
			int b = z.nextInt();
			
			System.out.println((int)Math.pow(a, b)%10);
		}
	}*/
}
