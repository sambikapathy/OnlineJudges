public class Solution {

	static int pylons(int k, int[] arr) {
		// fill 0's first
		boolean[] done = new boolean[arr.length];
		int count = 0;
		int start = k - 1;
		while (start < arr.length) {
			if (arr[start] != 0) {
				int max = start;
				for (int i = 0; i < k; i++) {
					if ((start + i) < arr.length) {
						done[start + i] = true;
						max = start + i;
					}
					if (start - i >= 0)
						done[start - i] = true;
				}
				count++;
				start = max + k;
			} else {
				int temp = start - (k - 1);
				int si = start;
				while (start >= temp) {
					if (arr[start] != 0) {
						for (int i = 0; i < k; i++) {
							if ((start + i) < arr.length)
								done[start + i] = true;
							if (start - i >= 0)
								done[start - i] = true;
						}
						count++;
						start += k;
						break;
					} else {
						start--;
					}
				}
				if (start < temp) {
					int index = si;
					while (index >= 0 && !done[index]) {
						index--;
					}
					index++;
					temp = index + (k - 1);
					while (temp > index) {
						if (arr[temp] != 0) {
							for (int i = 0; i < k; i++) {
								if ((temp + i) < arr.length)
									done[temp + i] = true;
								if (temp - i >= 0)
									done[temp - i] = true;
							}
							count++;
							start = temp += k;
							break;
						}
						temp--;
					}
					if (temp <= index) {
						return -1;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);

		int k = 2;
		int[] arr = { 1, 1, 1, 1, 1, 0, 1 };
		int result = pylons(k, arr);
		System.out.println(result);
		// in.close();
	}
}
