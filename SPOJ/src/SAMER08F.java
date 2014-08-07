import java.util.Scanner;


public class SAMER08F {

	public static void main (String[] args) throws java.lang.Exception
	  {
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();
		while(total != 0){
			System.out.println(getSquares(total));
			total = in.nextInt();
		}
	  }

	private static int getSquares(int total) {
		if(total == 1){
			return 1;
		}
		return (int) (Math.pow(total, 2)+getSquares(total-1));
	}
}
