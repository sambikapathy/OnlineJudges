/*
ID: your_id_here
LANG: JAVA
TASK: ride
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ride {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("./ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"ride.out")));
		String text = "";
		while (true) {
			String input1 = f.readLine();
			if (input1 == null) {
				break;
			}
			String input2 = f.readLine();

			if (findMod(input1) == findMod(input2)) {
				text = "GO";
			} else {
				text = "STAY";
			}
			out.println(text);
		}
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

	public static long findMod(String input) {
		// long mod = 1;
		long value = 1;
		for (int i = 0; i < input.length(); i++) {
			long mod = ((input.charAt(i) - 'A') + 1) % 47;
			value = (value * mod) % 47;
		}

		return value;
	}
}
