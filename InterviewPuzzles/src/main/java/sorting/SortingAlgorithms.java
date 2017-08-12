package sorting;

public class SortingAlgorithms {

	public static int[] bubbleSort(int[] input) {
		boolean done = false;
		int length = input.length;
		while (!done) {
			done = true;
			for (int i = 0; i < length - 1; i++) {
				if (input[i] > input[i + 1]) {
					swap(input, i, i + 1);
					done = false;
				}
			}
			length--;
		}
		return input;
	}

	public static int[] selectionSort(int[] input) {
		return input;
	}

	public static int[] insertionSort(int[] input) {

		for (int i = 1; i < input.length; i++) {
			int ele = input[i];
			int j = i - 1;

			while (j >= 0 && input[j] > ele) {
				input[j + 1] = input[j];
				j--;
			}
			input[j + 1] = ele;
		}
		return input;
	}

	public static void mergeSort(int[] input) {

	}

	public static void quickSort(int[] input) {
	}

	private static void swap(int[] input, int l, int r) {
		int t = input[r];
		input[r] = input[l];
		input[l] = t;

	}

	private static void printArray(int[] input) {
		for (int i : input) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static int[] getRandomArray(int size) {
		int[] input = new int[size];
		for (int i = 0; i < size; i++) {
			input[i] = (int) (Math.random() * 100);
		}
		return input;
	}

	public static void main(String[] args) {
		int size = 10;

		int[] input = getRandomArray(size);
		// printArray(bubbleSort(getRandomArray(size)));
		// printArray(insertionSort(getRandomArray(size)));

	}
}
