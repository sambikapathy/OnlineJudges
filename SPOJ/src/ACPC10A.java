import java.util.Scanner;


public class ACPC10A {

	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		while(true){
		int a1 = z.nextInt() , a2 = z.nextInt() , a3 = z.nextInt();
		if(a1==0&& a2==0 && a3==0){
			break;
		}
			int x = getNextAPTerm(a1, a2, a3);
			if (x != -1) {
				System.out.println("AP " + x);
			} else {
				int y = getNextGPTerm(a1, a2, a3);
				if(y!=-1){
					System.out.println("GP "+y);
				}

			}
		}
	}

	private static int getNextAPTerm(int a1, int a2, int a3) {
		if((a2-a1)==(a3-a2)){
			return a3+(a3-a2);
		}
		return -1;
	}

	private static int getNextGPTerm(int a1, int a2, int a3) {
		if(a2/a1 == a3/a2){
			return a3*(a2/a1);
		}
		return -1;
	}
}
