package careercup;

/**
 * amazon-interview-questions 0 of 0 votes 1 Answer
 * 
 * x={a,b,c}, y={p,q}, z={r,s} Define a Operation, x * y * z =
 * {{a,p,r},{a,p,s},{a,q,r},{a,q,s}......{c,q s}} Is to output all the results
 * in the order of each subset, implementing a class iterator that has Next()
 * and hasNext() methods
 */
public class MultiplyStrings {

	public static void main(String[] args) {
		char[][] input = { { 'a', 'b', 'c' }, { 'd', 'e' }, { 'f', 'g', 'h' } };
		print(input, 0, "");
		StringIterator iter = new StringIterator(input);
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	private static void print(char[][] input, int index, String prefix) {
		if (index >= input.length) {
			System.out.println(prefix);
			return;
		}
		for (int i = 0; i < input[index].length; i++) {
			print(input, index + 1, prefix + input[index][i]);
		}
	}

	private static class StringIterator {
		char[][] input;
		int[] index;

		public StringIterator(char[][] input) {
			this.input = input;
			index = new int[input.length];
		}

		public boolean hasNext() {
			for (int i = 0; i < index.length; i++) {
				if (index[i] >= input[i].length) {
					return false;
				}
			}
			return true;
		}

		public String next() {

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < index.length; i++) {
				sb.append(input[i][index[i]]);
			}

			boolean isDone = false;
			for (int i = index.length - 1; i >= 0; i--) {
				if (index[i] < input[i].length - 1) {
					index[i]++;
					isDone = true;
					break;
				} else {
					index[i] = 0;
				}
			}
			if (!isDone) {
				index[0] = input[0].length + 1;
			}

			return sb.toString();
		}
	}
}
