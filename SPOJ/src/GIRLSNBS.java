import java.util.Scanner;

public class GIRLSNBS {
	// //0 0 is 0, 10 4 is 2, 100 1 is 50, 100 2 is 34, 100 3 is 25.

	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		int g = z.nextInt(), b = z.nextInt();
		while (g != -1 && b != -1) {

			if (g == b) {
				if (g == 0) {
					System.out.println("0");
				} else {
					System.out.println("1");
				}
			} else {
				int min = 0, max = 0;
				if (g < b) {
					min = g;
					max = b;
				} else {
					min = b;
					max = g;
				}

				min++;
				int output = (int) Math.ceil((double) max / min);
				System.out.println(output);
			}

			g = z.nextInt();
			b = z.nextInt();
		}
	}
}
