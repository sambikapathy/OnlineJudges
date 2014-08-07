import java.util.Scanner;


public class ABSYS {

	public static void main(String[] args) throws Exception {
		Scanner z = new Scanner(System.in);

		int count = z.nextInt();
		for (int i = 0; i < count; i++) {
			int a1 = getInteger(z.next());
			z.next();
			int a2 = getInteger(z.next());
			z.next();
			int total = getInteger(z.next());
			if (a1 == -1) {
				System.out.println((total-a2)+" + "+a2+" = "+total);
			} else if (a2 == -1) {
				System.out.println(a1+" + "+(total-a1)+" = "+total);
			} else {
				System.out.println(a1+" + "+a2+" = "+(a1+a2));
			}
		}

	}

	private static int getInteger(String next) {
		try{
			return Integer.parseInt(next);
		}catch(Exception ex){
			return -1;
		}
	}
}
